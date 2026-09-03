// Last updated: 03/09/2026, 09:37:29
1class TreeNode {
2    int val;
3    TreeNode left, right;
4    TreeNode(int x) { val = x; }
5}
6
7public class Solution {
8    public boolean isValidBST(TreeNode root) {
9        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
10    }
11
12    private boolean validate(TreeNode node, long min, long max) {
13        if (node == null) return true;
14
15        // Current node must be within (min, max)
16        if (node.val <= min || node.val >= max) return false;
17
18        // Left subtree: values < node.val
19        // Right subtree: values > node.val
20        return validate(node.left, min, node.val) &&
21               validate(node.right, node.val, max);
22    }
23}
24