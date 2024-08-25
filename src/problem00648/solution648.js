/**
 * 648. Replace Words
 *
 * - Difficulty: Medium
 * - Topics: Array, Hash Table, String, Trie
 *
 * ------------------
 * Author: F. Waskito
 */

/**
 * @param {string[]} dictionary
 * @param {string} sentence
 * @return {string}
 */
const replaceWords = function (dictionary, sentence) {
  let words = sentence.split(" ");
  for (let [i, word] of words.entries()) {
    let shortest_root = "";
    let shortest_root_len = word.length;

    for (let root of dictionary) {
      if (word.startsWith(root) && root.length < shortest_root_len) {
        shortest_root = root;
        shortest_root_len = root.length;
      }
    }

    if (shortest_root) words[i] = shortest_root;
  }

  return words.join(" ");
};

// let dictionary = ["cat", "bat", "rat"];
// let sentence = "the cattle was rattled by the battery";
// expected: "the cat was rat by the bat"

// lst dictionary = ["a", "b", "c"];
// let sentence = "aadsfasf absbs bbab cadsfafs";
// expected: "a a b c"

let dictionary = ["catt", "cat", "bat", "rat"];
let sentence = "the cattle was rattled by the battery";
// expected: "the catt was rat by the bat"

console.log(replaceWords(dictionary, sentence));
