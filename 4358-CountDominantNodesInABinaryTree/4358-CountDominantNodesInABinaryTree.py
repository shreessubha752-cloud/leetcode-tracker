# Last updated: 20/07/2026, 10:13:10
class Solution:
    def countDominantNodes(self, root: TreeNode | None) -> int:
        ans = 0
        def dfs(node):
            nonlocal ans
            if not node:
                return float('-inf')
            leftMax = dfs(node.left)
            rightMax = dfs(node.right)
            currMax = max(node.val, leftMax, rightMax)
            if node.val == currMax:
                ans += 1
            return currMax
        dfs(root)
        return ans