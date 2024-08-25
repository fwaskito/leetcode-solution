/**
 * 1663. Smallest String with A Given Numric Value
 *
 * - Difficulty: Medium
 * - Topics: String, Greedy
 * - Hint:
 *      1. Think greedily.
 *      2. If you build the string from the end to the beginning, it will
 *         always be optimal to put the highest possible character at the
 *         current index.
 *
 * ------------------
 * Author: F. Waskito
 */

/**
 * @param {number} x
 * @return {string}
 */
const toAlphabet = function (x) {
  return String.fromCharCode(96 + x);
};

/**
 * @param {number} n
 * @param {number} k
 * @return {string}
 */
const getSmallestString = function (n, k) {
  let result = "";
  let max = 26;

  while (n > 0) {
    if (k > n) {
      let quotient = parseInt(k / max);
      let remainder = k % max;

      if (quotient > 1) {
        if (k - max > n) {
          while (k - max * quotient < n - quotient) {
            quotient--;
          }

          result = "z".repeat(quotient);
          k -= max * quotient;
          n -= quotient;
          continue;
        }

        k -= n - 1;
        result = toAlphabet(k) + result;
      } else if (quotient == 1) {
        if (remainder >= n - 1) {
          result = toAlphabet(max) + result;
          k -= max;
          max = remainder;
        } else {
          max -= n - (1 + remainder);
          result = toAlphabet(max) + result;
          k -= max;
        }
      } else {
        max = remainder - (n - 1);
        result = toAlphabet(max) + result;
        k -= max;
      }
    } else {
      return "a".repeat(n) + result;
    }

    n--;
  }

  return result;
};

// let n = 3;
// let k = 27;
// expected: 'aay'

// let n = 5;
// let k = 73;
// expected: 'aaszz'

// let n = 85;
// let k = 2159;
// expected:
// 'aayzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz'

let n = 95474;
let k = 2394483;

const start = performance.now();

console.log(getSmallestString(n, k));

const end = performance.now();
const execTime = Math.round(end - start);
console.log(`\nExecution time: ${execTime} ms.`);
