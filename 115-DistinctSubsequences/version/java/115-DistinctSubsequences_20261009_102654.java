// Last updated: 09/10/2026, 10:26:54
1public class Solution {
2    public int numDistinct(String s, String t) {
3        int m = s.length(), n = t.length();
4        int[][] dp = new int[m + 1][n + 1];
5
6        for (int i = 0; i <= m; i++) {
7            dp[i][0] = 1;
8        }
9
10        for (int i = 1; i <= m; i++) {
11            for (int j = 1; j <= n; j++) {
12                if (s.charAt(i - 1) == t.charAt(j - 1)) {
13                  
14                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
15                } else {
16                    dp[i][j] = dp[i - 1][j];
17                }
18            }
19        }
20
21        return dp[m][n];
22    }
23}
24