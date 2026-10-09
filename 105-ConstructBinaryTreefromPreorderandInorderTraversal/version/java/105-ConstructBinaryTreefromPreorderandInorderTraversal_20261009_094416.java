// Last updated: 09/10/2026, 09:44:16
1import java.util.*;
2
3class TreeNode {
4    int val;
5    TreeNode left, right;
6    TreeNode(int x) { val = x; }
7}
8
9public class Solution {
10    private Map<Integer, Integer> inorderIndexMap;
11    private int preorderIndex;
12
13    public TreeNode buildTree(int[] preorder, int[] inorder) {
14        inorderIndexMap = new HashMap<>();
15        preorderIndex = 0;
16
17        // Store inorder values with their indices for quick lookup
18        for (int i = 0; i < inorder.length; i++) {
19            inorderIndexMap.put(inorder[i], i);
20        }
21
22        return build(preorder, 0, inorder.length - 1);
23    }
24
25    private TreeNode build(int[] preorder, int left, int right) {
26        if (left > right) return null;
27
28        // Root is always the current element in preorder
29        int rootVal = preorder[preorderIndex++];
30        TreeNode root = new TreeNode(rootVal);
31
32        // Split inorder into left and right subtrees
33        int inorderIndex = inorderIndexMap.get(rootVal);
34
35        root.left = build(preorder, left, inorderIndex - 1);
36        root.right = build(preorder, inorderIndex + 1, right);
37
38        return root;
39    }
40}
41