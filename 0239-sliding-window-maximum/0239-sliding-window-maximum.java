
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        // There are n-k+1 windows
        int[] ans = new int[n - k + 1];

        // Store indices, not values
        Deque<Integer> dq = new ArrayDeque<>();

        int index = 0;

        for (int i = 0; i < n; i++) {

            // Step 1: Remove indices outside the current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Step 2: Remove smaller or equal values from the back
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // Step 3: Add the current index
            dq.offerLast(i);

            // Record maximum once the first full window is formed
            if (i >= k - 1) {
                ans[index] = nums[dq.peekFirst()];
                index++;
            }
        }

        return ans;
    }
}
