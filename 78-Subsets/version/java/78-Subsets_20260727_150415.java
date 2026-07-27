// Last updated: 27/07/2026, 15:04:15
1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> subsets(int[] nums) {
5        List<List<Integer>> result = new ArrayList<>();
6        backtrack(0, nums, new ArrayList<>(), result);
7        return result;
8    }
9    
10    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
11        if (index == nums.length) {
12            result.add(new ArrayList<>(current));
13            return;
14        }
15        
16        // Choice 1: Exclude nums[index]
17        backtrack(index + 1, nums, current, result);
18        
19        // Choice 2: Include nums[index]
20        current.add(nums[index]);
21        backtrack(index + 1, nums, current, result);
22        current.remove(current.size() - 1); // backtrack
23    }
24}
25