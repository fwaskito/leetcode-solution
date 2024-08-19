/*
 * 682. Baseball Game
 *
 * - Difficulty: Easy
 * - Topics: Array, Stack, Simulation
 */

import java.util.ArrayList;

public class Solution682 {
    public boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    public int calPoints(String[] operations) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            if (this.isInteger(operations[i])) {
                numbers.add(Integer.valueOf(operations[i]));
            } else {
                switch (operations[i]) {
                    case "+":
                        numbers.add(numbers.get(numbers.size() - 1)
                                + numbers.get(numbers.size() - 2));
                        break;
                    case "D":
                        numbers.add(numbers.get((numbers.size() - 1)) * 2);
                        break;
                    case "C":
                        numbers.remove(numbers.get(numbers.size() - 1));
                        break;

                }
            }
        }

        int sum = 0;
        for (int num : numbers)
            sum += num;

        return sum;
    }

    public static void main(String[] args) {
        // String[] operations = { "5", "2", "C", "D", "+" };
        // expected: 30

        // String[] operations = { "5", "-2", "4", "C", "D", "9", "+", "+" };
        // expected: 27

        String[] operations = { "1", "C" };
        // expected: 0

        long start = System.currentTimeMillis();

        Solution682 solution = new Solution682();
        System.out.println(solution.calPoints(operations));

        long end = System.currentTimeMillis();
        System.out.println("\nExecution time: " + (end - start) + " ms.");
    }
}
