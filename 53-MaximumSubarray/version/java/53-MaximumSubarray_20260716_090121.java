// Last updated: 16/07/2026, 09:01:21
1import java.util.*;
2
3class Solution {
4    public List<Integer> spiralOrder(int[][] matrix) {
5        List<Integer> result = new ArrayList<>();
6        
7        if (matrix == null || matrix.length == 0) return result;
8        
9        int top = 0;
10        int bottom = matrix.length - 1;
11        int left = 0;
12        int right = matrix[0].length - 1;
13        
14        while (top <= bottom && left <= right) {
15            // Traverse top row
16            for (int i = left; i <= right; i++) {
17                result.add(matrix[top][i]);
18            }
19            top++;
20            
21            // Traverse right column
22            for (int i = top; i <= bottom; i++) {
23                result.add(matrix[i][right]);
24            }
25            right--;
26            
27            // Traverse bottom row (if still valid)
28            if (top <= bottom) {
29                for (int i = right; i >= left; i--) {
30                    result.add(matrix[bottom][i]);
31                }
32                bottom--;
33            }
34            
35            // Traverse left column (if still valid)
36            if (left <= right) {
37                for (int i = bottom; i >= top; i--) {
38                    result.add(matrix[i][left]);
39                }
40                left++;
41            }
42        }
43        
44        return result;
45    }
46}
47