// Last updated: 02/09/2026, 09:13:56
1import java.util.*;
2
3class Solution {
4    public List<String> restoreIpAddresses(String s) {
5        List<String> result = new ArrayList<>();
6        backtrack(s, 0, new ArrayList<>(), result);
7        return result;
8    }
9
10    private void backtrack(String s, int start, List<String> path, List<String> result) {
11        if (path.size() == 4) {
12            if (start == s.length()) {
13                result.add(String.join(".", path));
14            }
15            return;
16        }
17
18        for (int len = 1; len <= 3; len++) {
19            if (start + len > s.length()) break;
20
21            String segment = s.substring(start, start + len);
22
23            if (isValid(segment)) {
24                path.add(segment);
25                backtrack(s, start + len, path, result);
26                path.remove(path.size() - 1);
27            }
28        }
29    }
30
31    private boolean isValid(String segment) {
32        if (segment.length() > 1 && segment.charAt(0) == '0') return false;
33        int value = Integer.parseInt(segment);
34        return value >= 0 && value <= 255;
35    }
36}
37