// Last updated: 20/07/2026, 10:35:13
1class Solution {
2    public int minPathSum(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        
6        int[][] dp = new int[m][n];
7        
8        // Base case
9        dp[0][0] = grid[0][0];
10        
11        // Fill first row
12        for (int j = 1; j < n; j++) {
13            dp[0][j] = dp[0][j-1] + grid[0][j];
14        }
15        
16        // Fill first column
17        for (int i = 1; i < m; i++) {
18            dp[i][0] = dp[i-1][0] + grid[i][0];
19        }
20        
21        // Fill rest of grid
22        for (int i = 1; i < m; i++) {
23            for (int j = 1; j < n; j++) {
24                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
25            }
26        }
27        
28        return dp[m-1][n-1];
29    }
30}
31