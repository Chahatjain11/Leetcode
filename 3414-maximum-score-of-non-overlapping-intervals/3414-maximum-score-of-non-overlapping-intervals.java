class Solution {

    int n;
    int[][] intervals;
    int[] nextIdx;

    static class Node {
        long score = -1;
        List<Integer> idxs = new ArrayList<>();
    }

    Node[][] t;

    // Find the first interval whose start > current interval's end
    int findNext(int r) {
        int low = 0;
        int high = n - 1;
        int result = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (intervals[mid][0] > r) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    // Compare two index lists lexicographically
    boolean isLexSmaller(List<Integer> a, List<Integer> b) {

        int len = Math.min(a.size(), b.size());

        for (int i = 0; i < len; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }

    // Starting from sorted index i, choose at most k intervals
    Node solve(int i, int k) {

        // Base case
        if (k == 0 || i >= n) {
            return new Node();
        }

        // Already calculated
        if (t[i][k].score != -1) {
            return t[i][k];
        }

        int weight = intervals[i][2];
        int idx = intervals[i][3];

        // Next non-overlapping interval
        int j = nextIdx[i];

        // Option 1: Skip current interval
        Node skip = solve(i + 1, k);

        // Option 2: Take current interval
        Node temp = solve(j, k - 1);

        Node take = new Node();

        take.score = temp.score + weight;

        take.idxs = new ArrayList<>(temp.idxs);

        take.idxs.add(idx);

        Collections.sort(take.idxs);

        // Compare skip and take
        Node result;

        if (skip.score > take.score) {
            result = skip;
        } else if (skip.score < take.score) {
            result = take;
        } else {
            result = isLexSmaller(skip.idxs, take.idxs)
                    ? skip
                    : take;
        }

        // Store answer in DP table
        t[i][k] = result;

        return result;
    }

    public int[] maximumWeight(List<List<Integer>> intervalsList) {

        n = intervalsList.size();

        // Format:
        // [start, end, weight, originalIndex]
        intervals = new int[n][4];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = intervalsList.get(i).get(0);
            intervals[i][1] = intervalsList.get(i).get(1);
            intervals[i][2] = intervalsList.get(i).get(2);

            // Save original index
            intervals[i][3] = i;
        }

        // Sort intervals
        Arrays.sort(intervals, (a, b) -> {

            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            if (a[1] != b[1]) {
                return a[1] - b[1];
            }

            if (a[2] != b[2]) {
                return a[2] - b[2];
            }

            return a[3] - b[3];
        });

        // Find the next non-overlapping interval for each interval
        nextIdx = new int[n];

        for (int i = 0; i < n; i++) {
            nextIdx[i] = findNext(intervals[i][1]);
        }

        // At most 4 intervals can be selected
        final int K = 4;

        // Initialize DP table
        t = new Node[n + 1][K + 1];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= K; k++) {
                t[i][k] = new Node();
            }
        }

        // Start recursion
        Node res = solve(0, K);

        // Convert List<Integer> into int[]
        int[] ans = new int[res.idxs.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.idxs.get(i);
        }

        return ans;
    }
}