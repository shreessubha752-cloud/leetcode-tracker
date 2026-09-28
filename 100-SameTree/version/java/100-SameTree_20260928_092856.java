// Last updated: 28/09/2026, 09:28:56
1// Definition for a binary tree node.
2class TreeNode {
3    int val;
4    TreeNode left;
5    TreeNode right;
6    TreeNode(int x) { val = x; }
7}
8 
9class Solution {
10    public boolean isSameTree(TreeNode p, TreeNode q) {
11        // Case 1: both are null → same
12        if (p == null && q == null) return true;
13
14        // Case 2: one is null, the other is not → different
15        if (p == null || q == null) return false;
16
17        // Case 3: values differ → different
18        if (p.val != q.val) return false;
19
20        // Case 4: check left and right subtrees recursively
21        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
22    }
23}
24