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


class Solution(object):
    def getSmallestString(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
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

    print Solution().getSmallestString(n_, k_)

    end = time.time()
    exec_time = round((end - start) * 10**3)
    print "\nExecution time: {} ms.".format(exec_time)
