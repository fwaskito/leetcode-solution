/**
 * 412. Fizz Buzz
 *
 * - Difficulty: Easy
 * - Topics: Math, String, Simulation
 *
 * ------------------
 * Author: F. Waskito
 */

/**
 * @param {number} n
 * @return {string[]}
 */
const fizzBuzz = function (n) {
  const result = [];
  for (let i = 1; i <= n; i++) {
    if (i % 3 == 0 && i % 5 == 0) {
      result.push("FizzBuzz");
    } else if (i % 3 == 0) {
      result.push("Fizz");
    } else if (i % 5 == 0) {
      result.push("Buzz");
    } else {
      result.push(String(i));
    }
  }

  return result;
};

// let n = 3;
// expected: ["1","2","Fizz"]

// let n = 5;
// expected: ["1","2","Fizz","4","Buzz"]

let n = 15;
// expected: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

const start = performance.now();

console.log(fizzBuzz(n));

const end = performance.now();
console.log(`\nExecution time: ${end - start} ms.`);
