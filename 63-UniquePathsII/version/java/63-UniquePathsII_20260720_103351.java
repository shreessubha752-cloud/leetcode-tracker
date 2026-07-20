// Last updated: 20/07/2026, 10:33:51
1class Solution {
2    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
3        int m = obstacleGrid.length;
4        int n = obstacleGrid[0].length;
5        
6        int[][] dp = new int[m][n];
7        
8        // Base case: start cell
9        dp[0][0] = (obstacleGrid[0][0] == 0) ? 1 : 0;
10        
11        // Fill first column
12        for (int i = 1; i < m; i++) {
13            if (obstacleGrid[i][0] == 0) {
14                dp[i][0] = dp[i-1][0];
15            }
16        }
17        
18        // Fill first row
19        for (int j = 1; j < n; j++) {
20            if (obstacleGrid[0][j] == 0) {
21                dp[0][j] = dp[0][j-1];
22            }
23        }
24        
25        // Fill rest of grid
26        for (int i = 1; i < m; i++) {
27            for (int j = 1; j < n; j++) {
28                if (obstacleGrid[i][j] == 0) {
29                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
30                }
31            }
32        }
33        
34        return dp[m-1][n-1];
35    }
36}
37