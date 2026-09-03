// Last updated: 03/09/2026, 09:36:16
1public class Solution {
2    public boolean isInterleave(String s1, String s2, String s3) {
3        int m = s1.length(), n = s2.length();
4        if (m + n != s3.length()) return false;
5
6        boolean[][] dp = new boolean[m + 1][n + 1];
7        dp[0][0] = true;
8
9        // Fill first column (using only s1)
10        for (int i = 1; i <= m; i++) {
11            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
12        }
13
14        // Fill first row (using only s2)
15        for (int j = 1; j <= n; j++) {
16            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
17        }
18
19        // Fill rest of the table
20        for (int i = 1; i <= m; i++) {
21            for (int j = 1; j <= n; j++) {
22                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
23                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
24            }
25        }
26
27        return dp[m][n];
28    }
29}
30