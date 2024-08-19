"""
1663. Smallest String With A Given Numeric Value

- Difficulty: Medium
- Topics: String, Greedy
- Hint:
    1. Think greedily.
    2. If you build the string from the end to the beginning, it will
       always be optimal to put the highest possible character at the
       current index.
"""

import time


class Solution:
    # def to_alphabet(self, x: int) -> str:
    #     alphabet_values = {
    #         1: "a",
    #         2: "b",
    #         3: "c",
    #         4: "d",
    #         5: "e",
    #         6: "f",
    #         7: "g",
    #         8: "h",
    #         9: "i",
    #         10: "j",
    #         11: "k",
    #         12: "l",
    #         13: "m",
    #         14: "n",
    #         15: "o",
    #         16: "p",
    #         17: "q",
    #         18: "r",
    #         19: "s",
    #         20: "t",
    #         21: "u",
    #         22: "v",
    #         23: "w",
    #         24: "x",
    #         25: "y",
    #         26: "z",
    #     }
    #     return alphabet_values[x]

    # def getSmallestString(self, n: int, k: int) -> str:
    #     """
    #     :type n: int
    #     :type k: int
    #     :rtype: str
    #     """
    #     maximum = 26
    #     result = ""
    #     for _ in range(n):
    #         quotient = int(k / maximum)
    #         remainder = k % maximum

    #         if k > n:
    #             if quotient > 1:
    #                 if (k - maximum) > n - 1:
    #                     result = self.to_alphabet(maximum) + result
    #                     k -= maximum
    #                 else:
    #                     k -= n - 1
    #                     result = self.to_alphabet(k) + result
    #             elif quotient == 1:
    #                 if remainder >= n - 1:
    #                     result = self.to_alphabet(maximum) + result
    #                     k -= maximum
    #                     maximum = remainder
    #                 else:
    #                     temp = maximum - (n - (1 + remainder))
    #                     result = self.to_alphabet(temp) + result
    #                     k -= temp
    #                     maximum = maximum - temp
    #             else:
    #                 maximum = remainder - (n - 1)
    #                 result = self.to_alphabet(maximum) + result
    #                 k -= maximum
    #         else:
    #             result = n * "a" + result
    #             break

    #         n -= 1

    #     return result

    def getSmallestString(self, n: int, k: int) -> str:
        result = ""
        max_ = 26

        while n > 0:
            if k > n:
                quotient = int(k / max_)
                remainder = k % max_

                if quotient > 1:
                    if (k - max_) > n:
                        while (k - max_ * quotient) < (n - quotient):
                            quotient -= 1

                        result = "z" * quotient
                        k -= max_ * quotient
                        n -= quotient
                        continue

                    k -= n - 1
                    result = chr(96 + k) + result

                elif quotient == 1:
                    if remainder >= (n - 1):
                        result = chr(96 + max_) + result
                        k -= max_
                        max_ = remainder
                    else:
                        max_ -= n - (1 + remainder)
                        result = chr(96 + max_) + result
                        k -= max_

                else:
                    max_ = remainder - (n - 1)
                    result = chr(96 + max_) + result
                    k -= max_

            else:
                return "a" * n + result

            n -= 1

        return result


if __name__ == "__main__":
    # n_ = 3
    # k_ = 27
    # expected: "aay"

    # n_ = 5
    # k_ = 73
    # expected: "aaszz"

    # n = 85
    # k = 2159
    # expected:
    # 'aayzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz'

    n_ = 95474
    k_ = 2394483

    start = time.time()

    print(Solution().getSmallestString(n_, k_))

    end = time.time()
    exec_time = round((end - start) * 10**3)
    print(f"\nExecution time: {exec_time} ms.")
