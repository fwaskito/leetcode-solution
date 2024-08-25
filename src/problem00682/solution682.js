/**
 * 682. Baseball Game
 *
 * - Difficulty: Easy
 * - Topics: Array, Stack, Simulation
 *
 * ------------------
 * Author: F. Waskito
 */

/**
 * @param {string[]} operations
 * @return {number}
 */
function calPoints(operations) {
  let numbers = [];
  for (let i = 0; i < operations.length; i++) {
    if (Number(operations[i])) {
      numbers.push(Number(operations[i]));
    } else {
      switch (operations[i]) {
        case "+":
          numbers.push(numbers.slice(-1)[0] + numbers.slice(-2)[0]);
          break;
        case "D":
          numbers.push(numbers.slice(-1)[0] * 2);
          break;
        case "C":
          numbers.pop();
          break;
      }
    }
  }

  let sum = 0;
  numbers.forEach((x) => {
    sum += x;
  });

  return sum;
}

// operations = ["5", "2", "C", "D", "+"];
// expected: 30

// let operations = ["5", "-2", "4", "C", "D", "9", "+", "+"];
// expected: 27

let operations = ["1", "C"];
// expected: 0

const start = performance.now();

console.log(calPoints(operations));

const end = performance.now();
console.log(`\nExecution time: ${end - start} ms.`);
