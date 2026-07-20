// Last updated: 20/07/2026, 10:13:48
import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums); // sort to handle duplicates
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, results);
        return results;
    }
    
    private void backtrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> results) {
        if (path.size() == nums.length) {
            results.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // Skip already used numbers
            if (used[i]) continue;
            
            // Skip duplicates: only use the first occurrence unless the previous duplicate is already used
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            
            // Choose
            used[i] = true;
            path.add(nums[i]);
            
            // Explore
            backtrack(nums, path, used, results);
            
            // Unchoose (backtrack)
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
