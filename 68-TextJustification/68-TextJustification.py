# Last updated: 20/07/2026, 10:13:24
from typing import List

class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        res = []
        i = 0
        while i < len(words):
            # Greedy fit
            length = len(words[i])
            j = i + 1
            while j < len(words) and length + 1 + len(words[j]) <= maxWidth:
                length += 1 + len(words[j])
                j += 1

            line = ""
            gaps = j - i - 1

            # Case 1: last line or single word
            if j == len(words) or gaps == 0:
                line = " ".join(words[i:j])
                line += " " * (maxWidth - len(line))
            else:
                # Case 2: fully justified
                spaces = (maxWidth - length) // gaps
                extra = (maxWidth - length) % gaps
                for k in range(i, j - 1):
                    line += words[k]
                    line += " " * (spaces + (1 if k - i < extra else 0) + 1)
                line += words[j - 1]
            res.append(line)
            i = j
        return res
