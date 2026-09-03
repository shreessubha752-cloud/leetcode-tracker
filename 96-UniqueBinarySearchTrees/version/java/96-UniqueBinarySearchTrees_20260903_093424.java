// Last updated: 03/09/2026, 09:34:24
1public class Solution {
2    public int numTrees(int n) {
3        int[] dp = new int[n + 1];
4        dp[0] = 1;
5        dp[1] = 1;
6
7        for (int nodes = 2; nodes <= n; nodes++) {
8            for (int root = 1; root <= nodes; root++) {
9                dp[nodes] += dp[root - 1] * dp[nodes - root];
10            }
11        }
12        return dp[n];
13    }
14}
15