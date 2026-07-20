// Last updated: 20/07/2026, 10:22:05
1class Solution {
2    public int uniquePaths(int m, int n) {
3        long res = 1;
4        for (int i = 1; i <= n - 1; i++) {
5            res = res * (m - 1 + i) / i;
6        }
7        return (int) res;
8    }
9}
10
11