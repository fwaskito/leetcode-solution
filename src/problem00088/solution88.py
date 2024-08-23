"""
88. Merge Sorted Array

- Diffulty: Easy
- Topics: Array, Two Pointers, Sorting
- Hint:
  1. You can easily solve this problem if you simply think about two elements
     at a time rather than two arrays. We know that each of the individual
     arrays is sorted. What we don't know is how they will intertwine. Can we
     take a local decision and arrive at an optimal solution?
  2. If you simply consider one element each at a time from the two arrays and
     make a decision and proceed accordingly, you will arrive at the optimal
     solution.
"""

import timeit
from typing import List


# class Solution:
#     def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
#         """
#         Do not return anything, modify nums1 in-place instead.
#         """
#         if m == 0:
#             nums1[:] = nums2[:]
#         elif m > 0 and n > 0:
#             if nums1[0] > nums2[n - 1]:
#                 temp = nums1[:n]
#                 nums1[:] = [*nums2, *temp]
#             else:
#                 for i in range(n):
#                     for j in range(m - 1, -1, -1):
#                         if nums2[i] >= nums1[j]:
#                             nums1[j + 1] = nums2[i]
#                             m += 1
#                             break

#                         nums1[j + 1] = nums1[j]
#                         if j == 0:
#                             nums1[j] = nums2[i]
#                             m += 1


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        if m == 0:
            nums1[:] = nums2[:]
        elif m > 0 and n > 0:
            if nums1[m - 1] <= nums2[0]:
                nums1[:] = [*nums1[:m], *nums2]
            elif nums1[0] >= nums2[n - 1]:
                nums1[:] = [*nums2, *nums1[:m]]
            else:
                nums1[:] = nums1[:m]
                i = 0

                while i < n:
                    if abs(nums2[i] - nums1[0]) <= abs(nums2[i] - nums1[m - 1]):

                        for j in range(m):
                            if nums2[i] <= nums1[j]:
                                duplicates = [nums2[i]]

                                for x in nums2[i + 1 :]:
                                    if x == nums2[i]:
                                        duplicates.append(x)
                                        i += 1
                                    else:
                                        break

                                nums1[j:] = [*duplicates, *nums1[j:]]

                                m += len(duplicates)
                                break

                    else:

                        for j in range(m - 1, -1, -1):
                            if nums2[i] >= nums1[j]:
                                duplicates = [nums2[i]]

                                for x in nums2[i + 1 :]:
                                    if x == nums2[i]:
                                        duplicates.append(x)
                                        i += 1
                                    else:
                                        break

                                nums1[j + 1 :] = [*duplicates, *nums1[j + 1 :]]

                                m += len(duplicates)
                                break

                    i += 1


if __name__ == "__main__":
    # nums1_ = [1, 2, 3, 0, 0, 0]
    # m_ = 3
    # nums2_ = [2, 5, 6]
    # n_ = 3

    # nums1_ = [1]
    # m_ = 1
    # nums2_ = []
    # n_ = 0
    # expected : [1]

    # nums1_ = [0]
    # m_ = 0
    # nums2_ = [1]
    # n_ = 1
    # expected : [1]

    # nums1_ = [2, 3, 0]
    # m_ = 2
    # nums2_ = [1]
    # n_ = 1
    # expected: [1,2,3]

    # nums1_ = [4, 5, 6, 0, 0, 0]
    # m_ = 3
    # nums2_ = [1, 2, 3]
    # n_ = 3
    # expected: [1, 2, 3, 4, 5, 6]

    # nums1_ = [1, 2, 3, 0, 0, 0]
    # m_ = 3
    # nums2_ = [4, 5, 6]
    # n_ = 3
    # expected: [1, 2, 3, 4, 5, 6]

    # nums1_ = [1, 0]
    # m_ = 1
    # nums2_ = [2]
    # n_ = 1
    # expected: [1, 2]

    # nums1_ = [1, 0, 0, 0, 0, 0]
    # m_ = 1
    # nums2_ = [2, 3, 4, 5, 6]
    # n_ = 5
    # expected: [1, 2, 3, 4, 5, 6]

    # nums1_ = [
    #     1,
    #     2,
    #     3,
    #     4,
    #     5,
    #     6,
    #     7,
    #     8,
    #     9,
    #     10,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    #     0,
    # ]
    # m_ = 10
    # nums2_ = [
    #     2,
    #     2,
    #     2,
    #     2,
    #     2,
    #     2,
    #     3,
    #     3,
    #     3,
    #     3,
    #     3,
    #     3,
    #     5,
    #     5,
    #     5,
    #     5,
    #     5,
    #     5,
    #     5,
    #     5,
    #     5,
    #     5,
    #     5,
    #     5,
    #     5,
    #     5,
    #     5,
    #     5,
    #     5,
    #     5,
    # ]
    # n_ = 30

    nums1_ = [
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
    ]
    m_ = 10
    nums2_ = [
        2,
        2,
        3,
        3,
        4,
        4,
        5,
        5,
        6,
        6,
    ]
    n_ = 10
    # expected: [1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 8, 9, 10]

    start = timeit.default_timer()

    Solution().merge(nums1_, m_, nums2_, n_)

    end = timeit.default_timer()
    exec_time = (end - start) / 10**6
    print(nums1_)
    print(f"\nExecution time: {exec_time} ms.")
