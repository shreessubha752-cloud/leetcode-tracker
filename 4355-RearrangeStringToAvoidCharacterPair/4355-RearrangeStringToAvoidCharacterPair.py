# Last updated: 20/07/2026, 10:13:11
class Solution:
    def rearrangeString(self, s, x, y):
        freq = [0] * 26
        for ch in s:
            freq[ord(ch) - ord('a')] += 1
        ans = []
        for i in range(25, -1, -1):
            c = chr(i + ord('a'))
            if c == x or c == y:
                continue
            ans.extend(c * freq[i])

        ans.extend(y * freq[ord(y) - ord('a')])
        ans.extend(x * freq[ord(x) - ord('a')])
        return "".join(ans)
            