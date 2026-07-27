// Last updated: 27/07/2026, 14:55:33
1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5        
6        int low = 0, high = m * n - 1;
7        
8        while (low <= high) {
9            int mid = low + (high - low) / 2;
10            int row = mid / n;
11            int col = mid % n;
12            
13            int midVal = matrix[row][col];
14            
15            if (midVal == target) {
16                return true;
17            } else if (midVal < target) {
18                low = mid + 1;
19            } else {
20                high = mid - 1;
21            }
22        }
23        
24        return false;
25    }
26}
27