# Last updated: 09/07/2026, 10:09:30
class Solution:
    def longestCommonPrefix(self, strs):
        if not strs:
            return ""

        # Start with the first string as the prefix
        prefix = strs[0]

        for string in strs[1:]:
            # Reduce the prefix until it matches the start of the current string
            while not string.startswith(prefix):
                prefix = prefix[:-1]
                if not prefix:
                    return ""

        return prefix