// Last updated: 18/07/2026, 09:02:38
1import java.util.*;
2
3class Solution {
4    public int[][] generateMatrix(int n) {
5        int[][] matrix = new int[n][n];
6        
7        int top = 0, bottom = n - 1;
8        int left = 0, right = n - 1;
9        int num = 1;
10        
11        while (top <= bottom && left <= right) {
12            // Fill top row
13            for (int i = left; i <= right; i++) {
14                matrix[top][i] = num++;
15            }
16            top++;
17            
18            // Fill right column
19            for (int i = top; i <= bottom; i++) {
20                matrix[i][right] = num++;
21            }
22            right--;
23            
24            // Fill bottom row
25            if (top <= bottom) {
26                for (int i = right; i >= left; i--) {
27                    matrix[bottom][i] = num++;
28                }
29                bottom--;
30            }
31            
32            // Fill left column
33            if (left <= right) {
34                for (int i = bottom; i >= top; i--) {
35                    matrix[i][left] = num++;
36                }
37                left++;
38            }
39        }
40        
41        return matrix;
42    }
43}
44