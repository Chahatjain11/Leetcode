class Solution {
    int MOD = 1_000_000_007;

    // dp[k][i] =
    // point i se exactly k segments banane ke ways
    int[][] dp = new int[1001][1001];

    public int numberOfSets(int n, int K) {

        // Exactly 0 segments ke ways
        for (int i = 0; i <= n; i++) {
            dp[0][i] = (i < n) ? 1 : 0;
        }

        // Pehle 1 segment, phir 2, ..., K segments
        for (int k = 1; k <= K; k++) {

            // Previous DP row ke suffix sums store karenge
            int[] prevRowSum = new int[n + 1];

            // Right se left suffix sum calculate karna
            for (int x = n - 1; x >= 0; x--) {
                prevRowSum[x] =
                    (prevRowSum[x + 1] + dp[k - 1][x]) % MOD;
            }

            // Current DP row ko right se left fill karna
            for (int i = n - 1; i >= 0; i--) {

                // Point i ko skip karo
                int skip = dp[k][i + 1];

                // Point i par segment start karo
                // Required sum already stored hai
                int take = prevRowSum[i + 1];

                // Total ways = skip + take
                dp[k][i] = (take + skip) % MOD;
            }
        }

        // Point 0 se exactly K segments
        return dp[K][0];
    }
}