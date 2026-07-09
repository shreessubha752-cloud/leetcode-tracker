# Last updated: 09/07/2026, 10:09:41
class Solution:
    def myAtoi(self, s):
        INT_MIN, INT_MAX = -2**31, 2**31 - 1
        i, n = 0, len(s)
        result = 0
        sign = 1

        # Step 1: Skip leading whitespaces
        while i < n and s[i] == ' ':
            i += 1

        # Step 2: Check for optional sign
        if i < n and s[i] in ['-', '+']:
            sign = -1 if s[i] == '-' else 1
            i += 1

        # Step 3: Convert digits to integer
        while i < n and s[i].isdigit():
            digit = int(s[i])

            # Step 4: Check for overflow
            if result > (INT_MAX - digit) // 10:
                return INT_MAX if sign == 1 else INT_MIN

            result = result * 10 + digit
            i += 1

        return sign * result