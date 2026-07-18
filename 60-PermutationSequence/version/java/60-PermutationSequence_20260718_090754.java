// Last updated: 18/07/2026, 09:07:54
1import java.util.*;
2
3class Solution {
4    public String getPermutation(int n, int k) {
5        // Precompute factorials
6        int[] fact = new int[n + 1];
7        fact[0] = 1;
8        for (int i = 1; i <= n; i++) {
9            fact[i] = fact[i - 1] * i;
10        }
11        
12        // List of numbers to pick from
13        List<Integer> numbers = new ArrayList<>();
14        for (int i = 1; i <= n; i++) {
15            numbers.add(i);
16        }
17        
18        // Convert k to 0-based index
19        k--;
20        
21        StringBuilder sb = new StringBuilder();
22        
23        for (int i = n; i >= 1; i--) {
24            int idx = k / fact[i - 1];
25            sb.append(numbers.get(idx));
26            numbers.remove(idx);
27            k %= fact[i - 1];
28        }
29        
30        return sb.toString();
31    }
32}
33