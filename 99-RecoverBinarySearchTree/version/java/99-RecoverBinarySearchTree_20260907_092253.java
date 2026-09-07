// Last updated: 07/09/2026, 09:22:53
1class TreeNode {
2    int val;
3    TreeNode left, right;
4    TreeNode(int x) { val = x; }
5}
6
7class Solution {
8    private TreeNode first = null;
9    private TreeNode second = null;
10    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);
11
12    public void recoverTree(TreeNode root) {
13        // Step 1: Inorder traversal to find misplaced nodes
14        inorder(root);
15
16        // Step 2: Swap their values
17        int temp = first.val;
18        first.val = second.val;
19        second.val = temp;
20    }
21
22    private void inorder(TreeNode root) {
23        if (root == null) return;
24
25        inorder(root.left);
26
27        // Detect violation
28        if (prev.val > root.val) {
29            if (first == null) {
30                first = prev;   // first wrong node
31            }
32            second = root;      // second wrong node
33        }
34        prev = root;
35
36        inorder(root.right);
37    }
38}
39