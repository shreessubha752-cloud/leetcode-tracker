// Last updated: 18/07/2026, 09:12:33
1class Solution {
2    public boolean isNumber(String s) {
3        s = s.trim(); // remove leading/trailing spaces
4        boolean seenDigit = false;
5        boolean seenDot = false;
6        boolean seenExp = false;
7        
8        for (int i = 0; i < s.length(); i++) {
9            char c = s.charAt(i);
10            
11            if (Character.isDigit(c)) {
12                seenDigit = true;
13            } 
14            else if (c == '+' || c == '-') {
15                // sign is only valid at start or right after exponent
16                if (i > 0 && !(s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
17                    return false;
18                }
19            } 
20            else if (c == '.') {
21                // dot not allowed after exponent or if already seen
22                if (seenDot || seenExp) {
23                    return false;
24                }
25                seenDot = true;
26            } 
27            else if (c == 'e' || c == 'E') {
28                // exponent only once, must follow a digit
29                if (seenExp || !seenDigit) {
30                    return false;
31                }
32                seenExp = true;
33                seenDigit = false; // reset, must see digit after exponent
34            } 
35            else {
36                return false; // invalid character
37            }
38        }
39        
40        return seenDigit;
41    }
42}
43