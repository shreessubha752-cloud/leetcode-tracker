// Last updated: 16/07/2026, 09:21:20
1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> permute(int[] nums) {
5        List<List<Integer>> results = new ArrayList<>();
6        boolean[] used = new boolean[nums.length];
7        backtrack(nums, new ArrayList<>(), used, results);
8        return results;
9    }
10    
11    private void backtrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> results) {
12        if (path.size() == nums.length) {
13            results.add(new ArrayList<>(path));
14            return;
15        }
16        
17        for (int i = 0; i < nums.length; i++) {
18            if (used[i]) continue;
19            
20            // Choose
21            used[i] = true;
22            path.add(nums[i]);
23            
24            // Explore
25            backtrack(nums, path, used, results);
26            
27            // Unchoose (backtrack)
28            path.remove(path.size() - 1);
29            used[i] = false;
30        }
31    }
32}
33