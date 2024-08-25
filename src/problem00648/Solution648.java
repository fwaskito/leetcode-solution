/*
 * 648. Replace Words
 *
 * - Difficulty: Medium
 * - Topics: Array, Hash Table, String, Trie
 *
 * ------------------
 * Author: F. Waskito
 */

import java.util.ArrayList;
import java.util.List;

class Solution648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String shortest_root = "";
            int shortest_root_len = words[i].length();

            for (String root : dictionary) {
                if (words[i].startsWith(root) && (root.length() < shortest_root_len)) {
                    shortest_root = root;
                    shortest_root_len = root.length();
                }
            }

            if (shortest_root.length() != 0) {
                words[i] = shortest_root;
            }
        }

        return String.join(" ", words);
    }

    public static void main(String[] args) {
        // List<String> dictionary = new ArrayList<>(List.of("cat", "bat", "rat"));
        // String sentence = "the cattle was rattled by the battery";
        // expected: "the cat was rat by the bat"

        // List<String> dictionary = new ArrayList<>(List.of("a", "b", "c"));
        // String sentence_ = "aadsfasf absbs bbab cadsfafs";
        // expected: "a a b c"

        List<String> dictionary = new ArrayList<>(List.of("catt", "cat", "bat", "rat"));
        String sentence = "the cattle was rattled by the battery";
        // expected: "the catt was rat by the bat"

        Solution648 solution = new Solution648();
        System.out.println(solution.replaceWords(dictionary, sentence));
    }
}