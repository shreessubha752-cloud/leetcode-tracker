// Last updated: 20/07/2026, 10:14:00
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // sort to handle duplicates
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList,
                           int[] candidates, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > remain) break; // pruning
            tempList.add(candidates[i]);
            backtrack(result, tempList, candidates, remain - candidates[i], i + 1);
            tempList.remove(tempList.size() - 1); // backtrack
        }
    }
}
