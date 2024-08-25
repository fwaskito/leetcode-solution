"""
648. Replace Words

- Diffulty: Medium
- Topics: Array, Hash Table, String, Trie

------------------
Author: F. Waskito
"""


class Solution(object):
    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
        words = sentence.split(" ")
        for i, word in enumerate(words):
            shortest_root = ""
            shortest_root_len = len(word)

            for root in dictionary:
                if word.startswith(root) and (len(root) < shortest_root_len):
                    shortest_root = root
                    shortest_root_len = len(root)

            if shortest_root:
                words[i] = shortest_root

        return " ".join(words)

if __name__ == "__main__":
        # dictionary_ = ["cat", "bat", "rat"]
    # sentence_ = "the cattle was rattled by the battery"
    # expected: "the cat was rat by the bat"

    # dictionary_ = ["a", "b", "c"]
    # sentence_ = "aadsfasf absbs bbab cadsfafs"
    # expected: "a a b c"

    # dictionary_ = ["a", "aa", "aaa", "aaaa"]
    # sentence_ = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
    # expected: "a a a a a a a a bbb baba a"

    dictionary_ = ["catt", "cat", "bat", "rat"]
    sentence_ = "the cattle was rattled by the battery"
    # expected: "the catt was rat by the bat"

    print Solution().replaceWords(dictionary_, sentence_)