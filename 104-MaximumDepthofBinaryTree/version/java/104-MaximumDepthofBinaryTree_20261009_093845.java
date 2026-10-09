// Last updated: 09/10/2026, 09:38:45
1class TreeNode {
2    int val;
3    TreeNode left, right;
4    TreeNode(int x) { val = x; }
5}
6
7public class Solution {
8    public int maxDepth(TreeNode root) {
9        if (root == null) return 0;  // Base case: empty tree
10        int leftDepth = maxDepth(root.left);   // Depth of left subtree
11        int rightDepth = maxDepth(root.right); // Depth of right subtree
12        return 1 + Math.max(leftDepth, rightDepth); // Current node + deeper side
13    }
14}
15