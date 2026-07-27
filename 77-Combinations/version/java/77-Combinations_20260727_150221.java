// Last updated: 27/07/2026, 15:02:21
1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> combine(int n, int k) {
5        List<List<Integer>> result = new ArrayList<>();
6        backtrack(1, n, k, new ArrayList<>(), result);
7        return result;
8    }
9    
10    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
11        if (current.size() == k) {
12            result.add(new ArrayList<>(current));
13            return;
14        }
15        
16        for (int i = start; i <= n; i++) {
17            current.add(i);              // choose
18            backtrack(i + 1, n, k, current, result); // explore
19            current.remove(current.size() - 1); // un-choose
20        }
21    }
22}
23