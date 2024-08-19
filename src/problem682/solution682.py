"""
682. Baseball Game

- Difficulty: Easy
- Topics: Array, Stack, Simulation
"""

import timeit
from typing import List


class Solution:
    def calPoints(self, operations: List[str]) -> int:
        numbers = []
        for e in operations:
            if e.lstrip("-").isdigit():
                numbers.append(int(e))
            else:
                if e == "+":
                    numbers.append(numbers[-1] + numbers[-2])
                elif e == "D":
                    numbers.append(numbers[-1] * 2)
                elif e == "C":
                    del numbers[-1]

        return sum(numbers)


if __name__ == "__main__":
    # operations_ = ["5", "2", "C", "D", "+"]
    # expected: 30

    # operations_ = ["5", "-2", "4", "C", "D", "9", "+", "+"]
    # expected: 27

    operations_ = ["1", "C"]
    # expected: 0

    start = timeit.default_timer()

    print(Solution().calPoints(operations_))

    end = timeit.default_timer()
    print(f"\nExecution time: {end - start} ns.")
