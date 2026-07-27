// Last updated: 27/07/2026, 15:21:56
1import java.util.*;
2
3class Solution {
4    public int maximalRectangle(char[][] matrix) {
5        if (matrix == null || matrix.length == 0) return 0;
6        
7        int m = matrix.length;
8        int n = matrix[0].length;
9        int[] heights = new int[n];
10        int maxArea = 0;
11        
12        for (int i = 0; i < m; i++) {
13            // Update histogram heights
14            for (int j = 0; j < n; j++) {
15                if (matrix[i][j] == '1') {
16                    heights[j] += 1;
17                } else {
18                    heights[j] = 0;
19                }
20            }
21            // Compute largest rectangle for this histogram
22            maxArea = Math.max(maxArea, largestRectangleArea(heights));
23        }
24        
25        return maxArea;
26    }
27    
28    private int largestRectangleArea(int[] heights) {
29        Stack<Integer> stack = new Stack<>();
30        int maxArea = 0;
31        int n = heights.length;
32        
33        for (int i = 0; i <= n; i++) {
34            int h = (i == n ? 0 : heights[i]);
35            while (!stack.isEmpty() && h < heights[stack.peek()]) {
36                int height = heights[stack.pop()];
37                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
38                maxArea = Math.max(maxArea, height * width);
39            }
40            stack.push(i);
41        }
42        
43        return maxArea;
44    }
45}
46