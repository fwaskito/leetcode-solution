/**
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
 */

/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
const merge = function (nums1, m, nums2, n) {
  if (m == 0) {
    nums1.splice(0, n, ...nums2);
  } else if (m > 0 && n > 0) {
    if (nums1[m - 1] <= nums2[0]) {
      nums1.splice(0, m + n, ...nums1.slice(0, m), ...nums2);
    } else if (nums1[0] >= nums2[n - 1]) {
      nums1.splice(0, m + n, ...nums2, ...nums1.slice(0, m));
    } else {
      nums1.splice(m, m + n);

      for (let i = 0; i < n; i++) {
        if (
          Math.abs(nums2[i] - nums1[0]) <= Math.abs(nums2[i] - nums1[m - 1])
        ) {
          for (let j = 0; j < m; j++) {
            if (nums2[i] <= nums1[j]) {
              let duplicates = [nums2[i]];

              for (x in nums2.slice(i + 1, n)) {
                if (x === nums2[i]) {
                  duplicates.push(x);
                  i++;
                } else {
                  break;
                }
              }

              nums1.splice(j, m - j, ...duplicates, ...nums1.slice(j, m));

              m += duplicates.length;
              break;
            }
          }
        } else {
          for (let j = m - 1; j >= 0; j--) {
            if (nums2[i] >= nums1[j]) {
              let duplicates = [nums2[i]];

              for (x in nums2.slice(i + 1, n)) {
                if (x === nums2[i]) {
                  duplicates.push(x);
                  i++;
                } else {
                  break;
                }
              }

              nums1.splice(
                j + 1,
                m - j,
                ...duplicates,
                ...nums1.slice(j + 1, m)
              );

              m += duplicates.length;
              break;
            }
          }
        }
      }
    }
  }
};

// let nums1 = [1, 2, 3, 0, 0, 0];
// let m = 3;
// let nums2 = [2, 5, 6];
// let n = 3;
// expected: [1, 2, 2, 3, 5, 6]

// let nums1 = [0];
// let m = 0;
// let nums2 = [1];
// let n = 1;
// expected: [1]

// let nums1 = [1];
// let m = 1;
// let nums2 = [];
// let n = 0;
// expected: [1]

// let nums1 = [4, 5, 6, 0, 0, 0];
// let m = 3;
// let nums2 = [1, 2, 3];
// let n = 3;
// expected: [1, 2, 3, 4, 5, 6]

// let nums1 = [1, 2, 3, 0, 0, 0];
// let m = 3;
// let nums2 = [4, 5, 6];
// let n = 3;
// expected: [1, 2, 3, 4, 5, 6]

let nums1 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
let m = 10;
let nums2 = [2, 2, 3, 3, 4, 4, 5, 5, 6, 6];
let n = 10;
// expected: [1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 8, 9, 10]

const start = performance.now();

merge(nums1, m, nums2, n);

const end = performance.now();
console.log(nums1);
console.log(`\nExecution time: ${end - start} ms.`);
