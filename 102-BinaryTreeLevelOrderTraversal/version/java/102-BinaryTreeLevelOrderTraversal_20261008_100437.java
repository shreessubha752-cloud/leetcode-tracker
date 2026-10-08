// Last updated: 08/10/2026, 10:04:37
1import java.util.*;
2  
3class TreeNode {
4    int val;
5    TreeNode left, right;
6    TreeNode(int x) { val = x; }
7}
8public class Solution {
9    public List<List<Integer>> levelOrder(TreeNode root) {
10        List<List<Integer>> result = new ArrayList<>();
11        if (root == null) return result;
12
13        Queue<TreeNode> queue = new LinkedList<>();
14        queue.offer(root);
15
16        while (!queue.isEmpty()) {
17            int size = queue.size();
18            List<Integer> level = new ArrayList<>();
19
20            for (int i = 0; i < size; i++) {
21                TreeNode node = queue.poll();
22                level.add(node.val);
23
24                if (node.left != null) queue.offer(node.left);
25                if (node.right != null) queue.offer(node.right);
26            }
27
28            result.add(level);
29        }
30
31        return result;
32    }
33}
34