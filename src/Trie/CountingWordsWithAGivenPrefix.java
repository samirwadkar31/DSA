package Trie;

public class CountingWordsWithAGivenPrefix {
    public static void main(String[] args) {
        String[] words = {"pay","attention","practice","attend"};
        String pref = "at";

//        Input: words = ["leetcode","win","loops","success"], pref = "code"
//        Output: 0

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        System.out.println(trie.countWordsWithPrefix(pref));

    }

}
