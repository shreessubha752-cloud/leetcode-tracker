# Last updated: 19/07/2026, 08:07:11
1class Solution:
2    def canReach(self, start: list[int], target: list[int]) -> bool:
3        return (start[0] + start[1]) % 2 == (target[0] + target[1]) % 2
4        