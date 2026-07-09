# Last updated: 09/07/2026, 10:09:39
class Solution:
    def isPalindrome(self, x):
        # Negative numbers and numbers ending in 0 (but not 0 itself) can't be palindromes
        if x < 0 or (x % 10 == 0 and x != 0):
            return False

        reversed_half = 0
        while x > reversed_half:
            reversed_half = reversed_half * 10 + x % 10
            x //= 10

        # For even and odd digit counts
        return x == reversed_half or x == reversed_half // 10