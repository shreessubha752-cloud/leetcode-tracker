// Last updated: 08/10/2026, 10:06:24
1import java.util.*;
2
3class TreeNode {
4    int val;
5    TreeNode left, right;
6    TreeNode(int x) { val = x; }
7}
8
9public class Solution {
10    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
11        List<List<Integer>> result = new ArrayList<>();
12        if (root == null) return result;
13
14        Queue<TreeNode> queue = new LinkedList<>();
15        queue.offer(root);
16        boolean leftToRight = true;
17
18        while (!queue.isEmpty()) {
19            int size = queue.size();
20            List<Integer> level = new ArrayList<>();
21
22            for (int i = 0; i < size; i++) {
23                TreeNode node = queue.poll();
24                level.add(node.val);
25
26                if (node.left != null) queue.offer(node.left);
27                if (node.right != null) queue.offer(node.right);
28            }
29
30            if (!leftToRight) {
31                Collections.reverse(level);
32            }
33            result.add(level);
34
35            leftToRight = !leftToRight; // flip direction
36        }
37
38        return result;
39    }
40}
41