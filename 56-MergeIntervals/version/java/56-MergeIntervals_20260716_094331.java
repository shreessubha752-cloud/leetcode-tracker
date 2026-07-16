// Last updated: 16/07/2026, 09:43:31
1import java.util.*;
2
3class Solution {
4    public int[][] merge(int[][] intervals) {
5        if (intervals.length == 0) return new int[0][];
6        
7        // Step 1: Sort by start time
8        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
9        
10        List<int[]> merged = new ArrayList<>();
11        
12        int[] current = intervals[0];
13        merged.add(current);
14        
15        for (int[] interval : intervals) {
16            if (interval[0] <= current[1]) {
17                // Overlap → merge
18                current[1] = Math.max(current[1], interval[1]);
19            } else {
20                // No overlap → new interval
21                current = interval;
22                merged.add(current);
23            }
24        }
25        
26        return merged.toArray(new int[merged.size()][]);
27    }
28}
29