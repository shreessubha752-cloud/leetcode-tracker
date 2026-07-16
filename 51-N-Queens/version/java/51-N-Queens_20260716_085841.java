// Last updated: 16/07/2026, 08:58:41
1import java.util.*;
2
3class Solution {
4    public List<List<String>> solveNQueens(int n) {
5        List<List<String>> results = new ArrayList<>();
6        char[][] board = new char[n][n];
7        
8        // Initialize board with '.'
9        for (int i = 0; i < n; i++) {
10            Arrays.fill(board[i], '.');
11        }
12        
13        // Sets to track columns and diagonals
14        Set<Integer> cols = new HashSet<>();
15        Set<Integer> diag1 = new HashSet<>(); // row - col
16        Set<Integer> diag2 = new HashSet<>(); // row + col
17        
18        backtrack(0, n, board, results, cols, diag1, diag2);
19        return results;
20    }
21    
22    private void backtrack(int row, int n, char[][] board, List<List<String>> results,
23                           Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
24        if (row == n) {
25            results.add(construct(board));
26            return;
27        }
28        
29        for (int col = 0; col < n; col++) {
30            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
31                continue; // not safe
32            }
33            
34            // Place queen
35            board[row][col] = 'Q';
36            cols.add(col);
37            diag1.add(row - col);
38            diag2.add(row + col);
39            
40            // Recurse
41            backtrack(row + 1, n, board, results, cols, diag1, diag2);
42            
43            // Backtrack (remove queen)
44            board[row][col] = '.';
45            cols.remove(col);
46            diag1.remove(row - col);
47            diag2.remove(row + col);
48        }
49    }
50    
51    private List<String> construct(char[][] board) {
52        List<String> res = new ArrayList<>();
53        for (char[] row : board) {
54            res.add(new String(row));
55        }
56        return res;
57    }
58}
59
60