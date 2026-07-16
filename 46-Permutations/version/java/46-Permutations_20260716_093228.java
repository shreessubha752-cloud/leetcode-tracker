// Last updated: 16/07/2026, 09:32:28
1class Solution {
2    public void rotate(int[][] matrix) {
3        int n = matrix.length;
4        
5        // Step 1: Transpose
6        for (int i = 0; i < n; i++) {
7            for (int j = i + 1; j < n; j++) {
8                int temp = matrix[i][j];
9                matrix[i][j] = matrix[j][i];
10                matrix[j][i] = temp;
11            }
12        }
13        
14        // Step 2: Reverse each row
15        for (int i = 0; i < n; i++) {
16            for (int j = 0; j < n / 2; j++) {
17                int temp = matrix[i][j];
18                matrix[i][j] = matrix[i][n - 1 - j];
19                matrix[i][n - 1 - j] = temp;
20            }
21        }
22    }
23}
24