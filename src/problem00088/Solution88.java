/*
 * 88. Merge Sorted Array
 *
 * - Difficulty: Easy
 * - Topics: Array, Two Pointers, Sorting
 * - Hint:
 *   1. You can easily solve this problem if you simply think about two elements
 *      at a time rather than two arrays. We know that each of the individual
 *      arrays is sorted. What we don't know is how they will intertwine. Can we
 *      take a local decision and arrive at an optimal solution?
 *   2. If you simply consider one element each at a time from the two arrays and
 *      make a decision and proceed accordingly, you will arrive at the optimal
 *      solution.
 *
 * ------------------
 * Author: F. Waskito
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> nums1List = new ArrayList<>(Arrays.stream(nums1).boxed().toList());
        nums1List = nums1List.subList(0, m + n);

        if (m == 0) {
            nums1List.clear();
            nums1List.addAll(new ArrayList<>(Arrays.stream(nums2).boxed().toList()));

        } else if (m > 0 && n > 0) {
            if (nums1[m - 1] <= nums2[0]) {
                nums1List = nums1List.subList(0, m);
                nums1List.addAll(new ArrayList<>(Arrays.stream(nums2).boxed().toList()));

            } else if (nums1[0] >= nums2[n - 1]) {
                List<Integer> temp = new ArrayList<>(nums1List.subList(0, m));
                nums1List.clear();
                nums1List.addAll(new ArrayList<>(Arrays.stream(nums2).boxed().toList()));
                nums1List.addAll(temp);

            } else {
                nums1List = nums1List.subList(0, m);
                List<Integer> nums2List = new ArrayList<>(Arrays.stream(nums2).boxed().toList());

                for (int i = 0; i < n; i++) {
                    if (Math.abs(nums2List.get(i) - nums1List.get(0)) <= Math
                            .abs(nums2List.get(i) - nums1List.get(m - 1))) {

                        for (int j = 0; j < m; j++) {
                            if (nums2List.get(i) <= nums1List.get(j)) {
                                List<Integer> duplicates = new ArrayList<>();
                                duplicates.add(nums2List.get(i));

                                for (int x : nums2List.subList(i + 1, n)) {
                                    if (x == nums2List.get(i)) {
                                        duplicates.add(x);
                                        i++;
                                    } else {
                                        break;
                                    }
                                }

                                List<Integer> temp = new ArrayList<>(nums1List.subList(0, j));
                                List<Integer> temp2 = new ArrayList<>(nums1List.subList(j, m));
                                nums1List.clear();
                                nums1List.addAll(temp);
                                nums1List.addAll(duplicates);
                                nums1List.addAll(temp2);

                                m += duplicates.size();
                                break;
                            }
                        }

                    } else {
                        for (int j = m - 1; j >= 0; j--) {
                            if (nums2List.get(i) >= nums1List.get(j)) {
                                List<Integer> duplicates = new ArrayList<>();
                                duplicates.add(nums2List.get(i));

                                for (int x : nums2List.subList(i + 1, n)) {
                                    if (x == nums2List.get(i)) {
                                        duplicates.add(x);
                                        i++;
                                    } else {
                                        break;
                                    }
                                }

                                List<Integer> temp = new ArrayList<>(nums1List.subList(0, j + 1));
                                List<Integer> temp2 = new ArrayList<>(nums1List.subList(j + 1, m));
                                nums1List.clear();
                                nums1List.addAll(temp);
                                nums1List.addAll(duplicates);
                                nums1List.addAll(temp2);

                                m += duplicates.size();
                                break;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < nums1List.size(); i++) {
            nums1[i] = nums1List.get(i);
        }
    }

    public static void main(String[] args) {
        // int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        // int m = 3;
        // int[] nums2 = { 2, 5, 6 };
        // int n = 3;
        // expected: [1, 2, 2, 3, 5, 6]

        // int[] nums1 = { 0 };
        // int m = 0;
        // int[] nums2 = { 1 };
        // int n = 1;
        // expected: [1]

        // int[] nums1 = { 1 };
        // int m = 1;
        // int[] nums2 = {};
        // int n = 0;
        // expected: [1]

        // int[] nums1 = { 4, 5, 6, 0, 0, 0 };
        // int m = 3;
        // int[] nums2 = { 1, 2, 3 };
        // int n = 3;
        // expected: [1, 2, 3, 4, 5, 6]

        // int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        // int m = 3;
        // int[] nums2 = { 4, 5, 6 };
        // int n = 3;
        // expected: [1, 2, 3, 4, 5, 6]

        int[] nums1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int m = 10;
        int[] nums2 = { 2, 2, 3, 3, 4, 4, 5, 5, 6, 6 };
        int n = 10;
        // expected: [1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 8, 9, 10]

        long start = System.currentTimeMillis();

        Solution88 soution = new Solution88();
        soution.merge(nums1, m, nums2, n);

        long end = System.currentTimeMillis();

        System.out.print("[");
        for (int x : nums1) {
            System.out.print(x + ", ");
        }
        System.out.println("]");
        System.out.println("\nExecution time: " + (end - start) + " ms.");
    }
}