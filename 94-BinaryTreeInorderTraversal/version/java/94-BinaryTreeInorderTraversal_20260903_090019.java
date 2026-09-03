// Last updated: 03/09/2026, 09:00:19
1import java.util.*;
2
3class TreeNode {
4    int val;
5    TreeNode left, right;
6    TreeNode(int x) { val = x; }
7}
8
9public class Solution {
10    public List<Integer> inorderTraversal(TreeNode root) {
11        List<Integer> result = new ArrayList<>();
12        inorder(root, result);
13        return result;
14    }
15
16    private void inorder(TreeNode node, List<Integer> result) {
17        if (node == null) return;
18        inorder(node.left, result);   // Step 1: Left
19        result.add(node.val);         // Step 2: Root
20        inorder(node.right, result);  // Step 3: Right
21    }
22}
23