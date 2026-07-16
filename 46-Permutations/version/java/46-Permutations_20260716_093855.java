// Last updated: 16/07/2026, 09:38:55
1class Solution {
2    public double myPow(double x, int n) {
3        long N = n; // use long to handle -2^31
4        if (N < 0) {
5            x = 1 / x;
6            N = -N;
7        }
8        return fastPow(x, N);
9    }
10    
11    private double fastPow(double x, long n) {
12        if (n == 0) return 1.0;
13        double half = fastPow(x, n / 2);
14        if (n % 2 == 0) {
15            return half * half;
16        } else {
17            return half * half * x;
18        }
19    }
20}
21