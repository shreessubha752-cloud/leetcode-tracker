// Last updated: 27/07/2026, 14:53:24
1class Solution {
2    public int minDistance(String word1, String word2) {
3        int m = word1.length();
4        int n = word2.length();
5        
6        int[][] dp = new int[m + 1][n + 1];
7        
8        // Base cases
9        for (int i = 0; i <= m; i++) dp[i][0] = i;
10        for (int j = 0; j <= n; j++) dp[0][j] = j;
11        
12        // Fill DP table
13        for (int i = 1; i <= m; i++) {
14            for (int j = 1; j <= n; j++) {
15                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
16                    dp[i][j] = dp[i - 1][j - 1];
17                } else {
18                    dp[i][j] = 1 + Math.min(
19                        dp[i - 1][j],      // delete
20                        Math.min(dp[i][j - 1], dp[i - 1][j - 1]) // insert or replace
21                    );
22                }
23            }
24        }
25        
26        return dp[m][n];
27    }
28}
29