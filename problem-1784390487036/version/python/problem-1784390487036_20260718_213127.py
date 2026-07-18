# Last updated: 18/07/2026, 21:31:27
1class Solution:
2    def rearrangeString(self, s, x, y):
3        freq = [0] * 26
4        for ch in s:
5            freq[ord(ch) - ord('a')] += 1
6        ans = []
7        for i in range(25, -1, -1):
8            c = chr(i + ord('a'))
9            if c == x or c == y:
10                continue
11            ans.extend(c * freq[i])
12
13        ans.extend(y * freq[ord(y) - ord('a')])
14        ans.extend(x * freq[ord(x) - ord('a')])
15        return "".join(ans)
16            