// Last updated: 20/07/2026, 15:43:53
1class Solution {
2    public int[] plusOne(int[] digits) {
3        int n = digits.length;
4        
5        // Traverse from last digit backwards
6        for (int i = n - 1; i >= 0; i--) {
7            if (digits[i] < 9) {
8                digits[i]++;   // just increment and return
9                return digits;
10            }
11            digits[i] = 0;     // set to 0 and carry over
12        }
13        
14        // If all digits were 9, we need an extra digit
15        int[] result = new int[n + 1];
16        result[0] = 1; // e.g. 999 + 1 = 1000
17        return result;
18    }
19}
20