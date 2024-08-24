/*
 * 412. Fizz Buzz
 *
 * - Difficulty: Easy
 * - Topics: Math, String, Simulation
 */

import java.util.ArrayList;
import java.util.List;

class Solution412 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // int n = 3;
        // expected: ["1","2","Fizz"]

        // int n = 5;
        // expected: ["1","2","Fizz","4","Buzz"]

        int n = 15;
        // expected:
        // ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

        long start = System.currentTimeMillis();

        Solution412 solution = new Solution412();
        System.out.println(solution.fizzBuzz(n));

        long end = System.currentTimeMillis();
        System.out.println("\nExecution time: " + (end - start) + " ms.");
    }
}