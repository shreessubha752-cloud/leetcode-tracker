// Last updated: 16/07/2026, 09:45:36
1import java.util.*;
2
3class Solution {
4    public int[][] insert(int[][] intervals, int[] newInterval) {
5        List<int[]> result = new ArrayList<>();
6        
7        int i = 0;
8        int n = intervals.length;
9        
10        // Step 1: Add all intervals before newInterval
11        while (i < n && intervals[i][1] < newInterval[0]) {
12            result.add(intervals[i]);
13            i++;
14        }
15        
16        // Step 2: Merge overlapping intervals
17        while (i < n && intervals[i][0] <= newInterval[1]) {
18            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
19            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
20            i++;
21        }
22        result.add(newInterval);
23        
24        // Step 3: Add remaining intervals
25        while (i < n) {
26            result.add(intervals[i]);
27            i++;
28        }
29        
30        return result.toArray(new int[result.size()][]);
31    }
32}
33