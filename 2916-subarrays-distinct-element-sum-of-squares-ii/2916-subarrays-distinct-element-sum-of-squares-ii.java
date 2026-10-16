import java.util.*;

class Solution {

    private static final int MOD = 1_000_000_007;

    class SegmentTree {

        long[] sum;       // Sum of distinct counts
        long[] sumSq;     // Sum of squares of distinct counts
        long[] lazy;      // Pending range updates
        int n;

        SegmentTree(int n) {
            this.n = n;

            sum = new long[4 * n];
            sumSq = new long[4 * n];
            lazy = new long[4 * n];
        }

        // Apply +val to every element in this segment
        void apply(int node, int left, int right, long val) {

            long len = right - left + 1L;

            // If each x becomes (x + val):
            // (x + val)^2 = x^2 + 2*val*x + val^2
            sumSq[node] = (
                sumSq[node]
                + 2L * val % MOD * sum[node] % MOD
                + val * val % MOD * len % MOD
            ) % MOD;

            // Update the sum of all elements
            sum[node] = (
                sum[node] + val * len % MOD
            ) % MOD;

            // Save the pending update
            lazy[node] = (lazy[node] + val) % MOD;
        }

        // Pass pending updates to child nodes
        void pushDown(int node, int left, int right) {

            if (lazy[node] == 0 || left == right) {
                return;
            }

            int mid = left + (right - left) / 2;

            apply(node * 2, left, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, right, lazy[node]);

            lazy[node] = 0;
        }

        // Add val to all positions in range [ql, qr]
        void update(
            int node, int left, int right,
            int ql, int qr, long val
        ) {

            // No overlap
            if (right < ql || left > qr) {
                return;
            }

            // Complete overlap
            if (ql <= left && right <= qr) {
                apply(node, left, right, val);
                return;
            }

            // Partial overlap: update children
            pushDown(node, left, right);

            int mid = left + (right - left) / 2;

            update(node * 2, left, mid, ql, qr, val);
            update(node * 2 + 1, mid + 1, right, ql, qr, val);

            // Merge child results
            sum[node] = (
                sum[node * 2] + sum[node * 2 + 1]
            ) % MOD;

            sumSq[node] = (
                sumSq[node * 2] + sumSq[node * 2 + 1]
            ) % MOD;
        }

        // Public method to update a range
        void update(int left, int right, long val) {
            if (left > right) {
                return;
            }

            update(1, 0, n - 1, left, right, val);
        }

        // Sum of squares across all starting positions
        long getSquareSum() {
            return sumSq[1];
        }
    }

    public int sumCounts(int[] nums) {

        int n = nums.length;

        SegmentTree segTree = new SegmentTree(n);

        // Stores the last index where each number appeared
        HashMap<Integer, Integer> lastSeen = new HashMap<>();

        long answer = 0;

        for (int r = 0; r < n; r++) {

            int num = nums[r];

            // Previous occurrence, or -1 if this is new
            int prev = lastSeen.getOrDefault(num, -1);

            // Distinct count increases by 1 for these starts
            segTree.update(prev + 1, r, 1);

            // Remember the latest occurrence
            lastSeen.put(num, r);

            // Add squares of distinct counts for all
            // subarrays ending at index r
            answer = (answer + segTree.getSquareSum()) % MOD;
        }

        return (int) answer;
    }
}