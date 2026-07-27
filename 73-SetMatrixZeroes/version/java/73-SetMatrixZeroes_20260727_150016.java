// Last updated: 27/07/2026, 15:00:16
1import java.util.*;
2
3class Solution {
4    public String minWindow(String s, String t) {
5        if (s.length() == 0 || t.length() == 0) return "";
6
7        Map<Character, Integer> need = new HashMap<>();
8        for (char c : t.toCharArray()) {
9            need.put(c, need.getOrDefault(c, 0) + 1);
10        }
11
12        Map<Character, Integer> window = new HashMap<>();
13        int have = 0, needCount = need.size();
14        int left = 0, right = 0;
15        int minLen = Integer.MAX_VALUE;
16        int start = 0;
17
18        while (right < s.length()) {
19            char c = s.charAt(right);
20            window.put(c, window.getOrDefault(c, 0) + 1);
21
22            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
23                have++;
24            }
25
26            while (have == needCount) {
27                // Update result
28                if (right - left + 1 < minLen) {
29                    minLen = right - left + 1;
30                    start = left;
31                }
32
33                // Shrink from left
34                char leftChar = s.charAt(left);
35                window.put(leftChar, window.get(leftChar) - 1);
36                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
37                    have--;
38                }
39                left++;
40            }
41            right++;
42        }
43
44        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
45    }
46}
47