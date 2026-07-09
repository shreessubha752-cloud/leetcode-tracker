# Last updated: 09/07/2026, 10:09:37
class Solution:
    def isMatch(self, s, p):
        m, n = len(s), len(p)
        # dp[i][j] = True if s[0..i-1] matches p[0..j-1]
        dp = [[False] * (n + 1) for _ in range(m + 1)]
        dp[0][0] = True  # Empty string matches empty pattern

        # Handle patterns like a*, a*b*, a*b*c* that can match empty string
        for j in range(2, n + 1):
            if p[j - 1] == '*':
                dp[0][j] = dp[0][j - 2]

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if p[j - 1] == '.' or p[j - 1] == s[i - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                elif p[j - 1] == '*':
                    # Zero occurrence of preceding element
                    dp[i][j] = dp[i][j - 2]
                    # One or more occurrence if preceding matches
                    if p[j - 2] == '.' or p[j - 2] == s[i - 1]:
                        dp[i][j] |= dp[i - 1][j]

        return dp[m][n]