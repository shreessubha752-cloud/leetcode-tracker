# Last updated: 20/07/2026, 10:10:33
1from typing import List
2
3class Solution:
4    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
5        res = []
6        i = 0
7        while i < len(words):
8            # Greedy fit
9            length = len(words[i])
10            j = i + 1
11            while j < len(words) and length + 1 + len(words[j]) <= maxWidth:
12                length += 1 + len(words[j])
13                j += 1
14
15            line = ""
16            gaps = j - i - 1
17
18            # Case 1: last line or single word
19            if j == len(words) or gaps == 0:
20                line = " ".join(words[i:j])
21                line += " " * (maxWidth - len(line))
22            else:
23                # Case 2: fully justified
24                spaces = (maxWidth - length) // gaps
25                extra = (maxWidth - length) % gaps
26                for k in range(i, j - 1):
27                    line += words[k]
28                    line += " " * (spaces + (1 if k - i < extra else 0) + 1)
29                line += words[j - 1]
30            res.append(line)
31            i = j
32        return res
33