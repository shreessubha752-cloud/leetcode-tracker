// Last updated: 16/07/2026, 08:56:21
1class Solution {
2    public boolean isMatch(String s, String p) {
3        int m = s.length();
4        int n = p.length();
5        
6        boolean[][] dp = new boolean[m + 1][n + 1];
7        
8        // Empty string and empty pattern match
9        dp[0][0] = true;
10        
11        // Handle patterns with leading '*'
12        for (int j = 1; j <= n; j++) {
13            if (p.charAt(j - 1) == '*') {
14                dp[0][j] = dp[0][j - 1];
15            }
16        }
17        
18        // Fill DP table
19        for (int i = 1; i <= m; i++) {
20            for (int j = 1; j <= n; j++) {
21                char pc = p.charAt(j - 1);
22                char sc = s.charAt(i - 1);
23                
24                if (pc == sc || pc == '?') {
25                    dp[i][j] = dp[i - 1][j - 1];
26                } else if (pc == '*') {
27                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
28                }
29            }
30        }
31        
32        return dp[m][n];
33    }
34}
35