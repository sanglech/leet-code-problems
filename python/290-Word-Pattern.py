
# Bijection is both onto and one-to-one: 
# The counts of distinct elements in two groups 
# and the count of distinct mappings are all equal.

from itertools import zip_longest

class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        wordList = s.split()

        return (len(set(pattern)) ==
                len(set(wordList)) ==
                len(set(zip_longest(pattern,wordList))))
