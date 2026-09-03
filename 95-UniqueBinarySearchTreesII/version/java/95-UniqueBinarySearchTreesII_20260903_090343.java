// Last updated: 03/09/2026, 09:03:43
1import java.util.*;
2
3class TreeNode {
4    int val;
5    TreeNode left, right;
6    TreeNode(int x) { val = x; }
7}
8
9public class Solution {
10    public List<TreeNode> generateTrees(int n) {
11        if (n == 0) return new ArrayList<>();
12        return buildTrees(1, n);
13    }
14
15    private List<TreeNode> buildTrees(int start, int end) {
16        List<TreeNode> result = new ArrayList<>();
17        if (start > end) {
18            result.add(null); // empty tree
19            return result;
20        }
21
22        // Choose each number as root
23        for (int i = start; i <= end; i++) {
24            List<TreeNode> leftTrees = buildTrees(start, i - 1);
25            List<TreeNode> rightTrees = buildTrees(i + 1, end);
26
27            // Combine left and right subtrees
28            for (TreeNode left : leftTrees) {
29                for (TreeNode right : rightTrees) {
30                    TreeNode root = new TreeNode(i);
31                    root.left = left;
32                    root.right = right;
33                    result.add(root);
34                }
35            }
36        }
37        return result;
38    }
39}
40