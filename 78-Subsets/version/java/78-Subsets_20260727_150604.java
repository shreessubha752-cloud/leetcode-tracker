// Last updated: 27/07/2026, 15:06:04
1class Solution {
2    public boolean exist(char[][] board, String word) {
3        int m = board.length;
4        int n = board[0].length;
5        
6        for (int i = 0; i < m; i++) {
7            for (int j = 0; j < n; j++) {
8                if (dfs(board, word, i, j, 0)) {
9                    return true;
10                }
11            }
12        }
13        return false;
14    }
15    
16    private boolean dfs(char[][] board, String word, int i, int j, int index) {
17        if (index == word.length()) return true;
18        
19        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length 
20            || board[i][j] != word.charAt(index)) {
21            return false;
22        }
23        
24        char temp = board[i][j];
25        board[i][j] = '#'; // mark visited
26        
27        boolean found = dfs(board, word, i + 1, j, index + 1) ||
28                        dfs(board, word, i - 1, j, index + 1) ||
29                        dfs(board, word, i, j + 1, index + 1) ||
30                        dfs(board, word, i, j - 1, index + 1);
31        
32        board[i][j] = temp; // backtrack
33        return found;
34    }
35}
36