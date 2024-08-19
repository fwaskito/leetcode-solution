/*
 * 1663. Smallest String With A Given Numric Value
 *
 * - Difficulty: Medium
 * - Topics: String, Greedy
 * - Hint:
 *      1. Think greedily.
 *      2. If you build the string from the end to the beginning, it will
 *         always be optimal to put the highest possible character at the
 *         current index.
 */

public class Solution1663 {

    // private Map<Integer, String> alphabets;

    // public Q1663() {
    // this.generateDictAlphabets();
    // }

    // private void generateDictAlphabets() {
    // this.alphabets = new HashMap<Integer, String>();
    // alphabets.put(1, "a");
    // alphabets.put(2, "b");
    // alphabets.put(3, "c");
    // alphabets.put(4, "d");
    // alphabets.put(5, "e");
    // alphabets.put(6, "f");
    // alphabets.put(7, "g");
    // alphabets.put(8, "h");
    // alphabets.put(9, "i");
    // alphabets.put(10, "j");
    // alphabets.put(11, "k");
    // alphabets.put(12, "l");
    // alphabets.put(13, "m");
    // alphabets.put(14, "n");
    // alphabets.put(15, "o");
    // alphabets.put(16, "p");
    // alphabets.put(17, "q");
    // alphabets.put(18, "r");
    // alphabets.put(19, "s");
    // alphabets.put(20, "t");
    // alphabets.put(21, "u");
    // alphabets.put(22, "v");
    // alphabets.put(23, "w");
    // alphabets.put(24, "x");
    // alphabets.put(25, "y");
    // alphabets.put(26, "z");
    // }

    // public String toAlphabet(int x) {
    // return this.alphabets.get(x);
    // }

    // public String getSmallestString(int n, int k) {
    // String result = "";
    // int max = 26;

    // while (n > 0) {
    // int quotient = Integer.valueOf(k / max);
    // int remainder = k % max;

    // if (k > n) {
    // if (quotient > 1) {
    // if ((k - max) > (n - 1)) {
    // result = this.toAlphabet(max) + result;
    // k -= max;
    // } else {
    // k -= n - 1;
    // result = this.toAlphabet(k) + result;
    // }

    // } else if (quotient == 1) {
    // if (remainder >= (n - 1)) {
    // result = this.toAlphabet(max) + result;
    // k -= max;
    // max = remainder;
    // } else {
    // max -= (n - (1 + remainder));
    // result = this.toAlphabet(max) + result;
    // k -= max;
    // }

    // } else {
    // max = remainder - (n - 1);
    // result = this.toAlphabet(max) + result;
    // k -= max;
    // }

    // } else {
    // return "a".repeat(n) + result;
    // }

    // n--;

    // }

    // return result;
    // }

    public String toAlphabet(int x) {
        return String.valueOf((char) (96 + x));
    }

    /*
     * New approach
     * In case when n = 95474 and k = 2394483:
     * - decrease 91962 to 2 iterations; &
     * - decrease 2451 ms to to 671 ms (avg) runtimes
     */
    public String getSmallestString(int n, int k) {
        String result = "";
        int max = 26;

        while (n > 0) {
            if (k > n) {
                int quotient = Integer.valueOf(k / max);
                int remainder = k % max;

                if (quotient > 1) {
                    if ((k - max) > n) {
                        while ((k - max * quotient) < (n - quotient)) {
                            quotient--;
                        }

                        result = "z".repeat(quotient);
                        k -= max * quotient;
                        n -= quotient;
                        continue;
                    }

                    k -= (n - 1);
                    result = this.toAlphabet(k) + result;

                } else if (quotient == 1) {
                    if (remainder >= (n - 1)) {
                        result = this.toAlphabet(max) + result;
                        k -= max;
                        max = remainder;
                    } else {
                        max -= (n - (1 + remainder));
                        result = this.toAlphabet(max) + result;
                        k -= max;
                    }

                } else {
                    max = remainder - (n - 1);
                    result = this.toAlphabet(max) + result;
                    k -= max;
                }

            } else {
                return "a".repeat(n) + result;
            }

            n--;
        }

        return result;
    }

    public static void main(String[] args) {
        // int n = 3;
        // int k = 27;
        // expected: "aay"

        // int n = 5;
        // int k = 73;
        // expected: "aaszz"

        // int n = 95474;
        // int k = 2394483;
        // failed: time limit exceeded
        // [SOLVED]: new approach

        // int n = 504;
        // int k = 13000; (26*500 = 13000)
        // expected: 2 iteration

        // int n = 85;
        // int k = 2159;
        // expected:
        // "aayzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"

        // int n = 4;
        // int k = 100;
        // Runtime Error
        // java.lang.ArithmeticException: / by zero
        // [SOLVED]: replace for loops to while loops

        // int n = 80;
        // int k = 576;
        // step: 1.1.1 -> 1.1.2 -> 2
        // output:
        // "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(zz)zzzzzzzzzzzzzzzzzzz"
        // expected:
        // "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(av)zzzzzzzzzzzzzzzzzzz"

        // =====================================================

        // int n = 2;
        // int k = 2;
        // step: 2

        // int n = 2;
        // int k = 52;
        // step: 1.1.1

        // int n = 5;
        // int k = 54;
        // step: 1.1.1 -> 1.2.2 -> 2

        // int n = 5;
        // int k = 56;
        // step: 1.1.1 -> 1.3 -> 2

        // int n = 5;
        // int k = 55;
        // step: 1.1.1 -> 2

        // int n = 50;
        // int k = 55;
        // step: 1.1.2 -> 2

        // int n = 5;
        // int k = 50/51;
        // step: 1.2.1 -> 1.2.2 -> 2

        // int n = 3;
        // int k = 29/30;
        // step: 1.2.1 -> 1.2.2 -> 2

        // int n = 2;
        // int k = 30;
        // step: 1.2.1 -> 1.2.1

        // int n = 3;
        // int k = 27;
        // step: 1.2.2 -> 2

        // int n = 20;
        // int k = 27;
        // step: 1.2.2 -> 2

        int n = 95474;
        int k = 2394483;

        long start = System.currentTimeMillis();

        Solution1663 solution = new Solution1663();
        System.out.println(solution.getSmallestString(n, k));

        long end = System.currentTimeMillis();
        long execTime = end - start;
        System.out.println("\nExecution time: " + execTime + " ms.");
    }
}
