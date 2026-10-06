// Last updated: 06/10/2026, 16:00:03
1// Definition for a binary tree node.
2class TreeNode {
3    int val;
4    TreeNode left;
5    TreeNode right;
6    TreeNode(int x) { val = x; }
7}
8
9class Solution {
10    public boolean isSymmetric(TreeNode root) {
11        if (root == null) return true;
12        return isMirror(root.left, root.right);
13    }
14
15    private boolean isMirror(TreeNode t1, TreeNode t2) {
16        // Case 1: both are null → symmetric
17        if (t1 == null && t2 == null) return true;
18
19        // Case 2: one is null → not symmetric
20        if (t1 == null || t2 == null) return false;
21
22        // Case 3: values differ → not symmetric
23        if (t1.val != t2.val) return false;
24
25        // Case 4: check mirrored children
26        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
27    }
28}
29