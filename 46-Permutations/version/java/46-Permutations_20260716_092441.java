// Last updated: 16/07/2026, 09:24:41
1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> permuteUnique(int[] nums) {
5        List<List<Integer>> results = new ArrayList<>();
6        Arrays.sort(nums); // sort to handle duplicates
7        boolean[] used = new boolean[nums.length];
8        backtrack(nums, new ArrayList<>(), used, results);
9        return results;
10    }
11    
12    private void backtrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> results) {
13        if (path.size() == nums.length) {
14            results.add(new ArrayList<>(path));
15            return;
16        }
17        
18        for (int i = 0; i < nums.length; i++) {
19            // Skip already used numbers
20            if (used[i]) continue;
21            
22            // Skip duplicates: only use the first occurrence unless the previous duplicate is already used
23            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
24            
25            // Choose
26            used[i] = true;
27            path.add(nums[i]);
28            
29            // Explore
30            backtrack(nums, path, used, results);
31            
32            // Unchoose (backtrack)
33            path.remove(path.size() - 1);
34            used[i] = false;
35        }
36    }
37}
38