// Last updated: 20/07/2026, 10:18:50
1import java.util.*;
2
3class Solution {
4    public int largestRectangleArea(int[] heights) {
5        Stack<Integer> stack = new Stack<>();
6        int maxArea = 0;
7        int n = heights.length;
8
9        for (int i = 0; i <= n; i++) {
10            int h = (i == n ? 0 : heights[i]);
11            while (!stack.isEmpty() && h < heights[stack.peek()]) {
12                int height = heights[stack.pop()];
13                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
14                maxArea = Math.max(maxArea, height * width);
15            }
16            stack.push(i);
17        }
18        return maxArea;
19    }
20}
21