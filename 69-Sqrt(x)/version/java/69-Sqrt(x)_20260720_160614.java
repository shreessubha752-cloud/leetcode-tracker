// Last updated: 20/07/2026, 16:06:14
1class Solution {
2    public int mySqrt(int x) {
3        if (x < 2) return x;  // handle 0 and 1 directly
4
5        int left = 1, right = x / 2, ans = 0;
6
7        while (left <= right) {
8            int mid = left + (right - left) / 2;
9            long sq = (long) mid * mid; // use long to avoid overflow
10
11            if (sq == x) {
12                return mid; // perfect square
13            } else if (sq < x) {
14                ans = mid;      // candidate answer
15                left = mid + 1; // search higher
16            } else {
17                right = mid - 1; // search lower
18            }
19        }
20        return ans;
21    }
22
23    // Quick test
24    public static void main(String[] args) {
25        Solution sol = new Solution();
26        System.out.println(sol.mySqrt(4));  // Output: 2
27        System.out.println(sol.mySqrt(8));  // Output: 2
28        System.out.println(sol.mySqrt(25)); // Output: 5
29        System.out.println(sol.mySqrt(2));  // Output: 1
30    }
31}
32