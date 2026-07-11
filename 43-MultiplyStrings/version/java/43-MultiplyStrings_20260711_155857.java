// Last updated: 11/07/2026, 15:58:57
1class Solution {
2    public String multiply(String num1, String num2) {
3        if (num1.equals("0") || num2.equals("0")) return "0";
4
5        int m = num1.length(), n = num2.length();
6        int[] pos = new int[m + n];
7
8        for (int i = m - 1; i >= 0; i--) {
9            for (int j = n - 1; j >= 0; j--) {
10                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
11                int p1 = i + j, p2 = i + j + 1;
12                int sum = mul + pos[p2];
13
14                pos[p1] += sum / 10;
15                pos[p2] = sum % 10;
16            }
17        }
18
19        StringBuilder sb = new StringBuilder();
20        for (int p : pos) {
21            if (!(sb.length() == 0 && p == 0)) { // skip leading zeros
22                sb.append(p);
23            }
24        }
25        return sb.length() == 0 ? "0" : sb.toString();
26    }
27}
28