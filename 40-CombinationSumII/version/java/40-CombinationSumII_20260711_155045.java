// Last updated: 11/07/2026, 15:50:45
1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
5        List<List<Integer>> result = new ArrayList<>();
6        Arrays.sort(candidates); // sort to handle duplicates
7        backtrack(result, new ArrayList<>(), candidates, target, 0);
8        return result;
9    }
10
11    private void backtrack(List<List<Integer>> result, List<Integer> tempList,
12                           int[] candidates, int remain, int start) {
13        if (remain == 0) {
14            result.add(new ArrayList<>(tempList));
15            return;
16        }
17        for (int i = start; i < candidates.length; i++) {
18            // Skip duplicates
19            if (i > start && candidates[i] == candidates[i - 1]) continue;
20            if (candidates[i] > remain) break; // pruning
21            tempList.add(candidates[i]);
22            backtrack(result, tempList, candidates, remain - candidates[i], i + 1);
23            tempList.remove(tempList.size() - 1); // backtrack
24        }
25    }
26}
27