// Last updated: 20/07/2026, 16:17:50
1import java.util.*;
2
3class Solution {
4    public String simplifyPath(String path) {
5        Deque<String> stack = new ArrayDeque<>();
6        String[] parts = path.split("/");
7
8        for (String part : parts) {
9            if (part.equals("") || part.equals(".")) {
10                continue; // skip empty or current directory
11            } else if (part.equals("..")) {
12                if (!stack.isEmpty()) {
13                    stack.pop(); // go up one level
14                }
15            } else {
16                stack.push(part); // valid directory/file
17            }
18        }
19
20        // Build canonical path
21        StringBuilder result = new StringBuilder();
22        for (String dir : stack) {
23            result.insert(0, "/" + dir);
24        }
25
26        return result.length() == 0 ? "/" : result.toString();
27    }
28
29    // Quick test
30    public static void main(String[] args) {
31        Solution sol = new Solution();
32        System.out.println(sol.simplifyPath("/home/")); // "/home"
33        System.out.println(sol.simplifyPath("/home//foo/")); // "/home/foo"
34        System.out.println(sol.simplifyPath("/home/user/Documents/../Pictures")); // "/home/user/Pictures"
35        System.out.println(sol.simplifyPath("/../")); // "/"
36        System.out.println(sol.simplifyPath("/.../a/../b/c/../d/./")); // "/.../b/d"
37    }
38}
39