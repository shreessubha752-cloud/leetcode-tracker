// Last updated: 16/07/2026, 08:59:46
1class Solution {
2    private int count = 0;
3
4    public int totalNQueens(int n) {
5        // Sets to track columns and diagonals
6        boolean[] cols = new boolean[n];
7        boolean[] diag1 = new boolean[2 * n]; // row - col offset
8        boolean[] diag2 = new boolean[2 * n]; // row + col offset
9        
10        backtrack(0, n, cols, diag1, diag2);
11        return count;
12    }
13
14    private void backtrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
15        if (row == n) {
16            count++;
17            return;
18        }
19        
20        for (int col = 0; col < n; col++) {
21            int d1 = row - col + n; // shift to avoid negative index
22            int d2 = row + col;
23            
24            if (cols[col] || diag1[d1] || diag2[d2]) continue;
25            
26            // Place queen
27            cols[col] = diag1[d1] = diag2[d2] = true;
28            
29            backtrack(row + 1, n, cols, diag1, diag2);
30            
31            // Remove queen (backtrack)
32            cols[col] = diag1[d1] = diag2[d2] = false;
33        }
34    }
35}
36