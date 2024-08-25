"""
412. Fizz Buzz

- Diffulty: Easy
- Topics: Math, String, Simulation

------------------
Author: F. Waskito
"""

import timeit


class Solution(object):
    def fizzBuzz(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        result = []
        for i in range(1, n + 1):
            if (i % 3 == 0) and (i % 5 == 0):
                result.append("FizzBuzz")
            elif i % 3 == 0:
                result.append("Fizz")
            elif i % 5 == 0:
                result.append("Buzz")
            else:
                result.append(str(i))

        return result

if __name__ == "__main__":
    # n_ = 3
    # expected: ["1","2","Fizz"]

    # n_ = 5
    # expected: ["1","2","Fizz","4","Buzz"]

    n_ = 15
    # expected: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

    start = timeit.default_timer()

    print Solution().fizzBuzz(n_)

    end = timeit.default_timer()
    exec_time = (end - start) / 10**6
    print "\nExecution time: {} ms.".format(exec_time)