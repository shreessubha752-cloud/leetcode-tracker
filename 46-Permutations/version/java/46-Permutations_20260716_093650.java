// Last updated: 16/07/2026, 09:36:50
1import java.util.*;
2
3class Solution {
4    public List<List<String>> groupAnagrams(String[] strs) {
5        Map<String, List<String>> map = new HashMap<>();
6        
7        for (String s : strs) {
8            // Sort characters to form the key
9            char[] chars = s.toCharArray();
10            Arrays.sort(chars);
11            String key = new String(chars);
12            
13            // Add to the group
14            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
15        }
16        
17        return new ArrayList<>(map.values());
18    }
19}
20