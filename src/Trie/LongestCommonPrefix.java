package Trie;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
//        if (strs.length == 0) return "";
        Trie trie = new Trie();
        for (String word : strs) {
            trie.insert(word);
        }
        String ans = trie.longestCommonPrefix(strs.length);
        System.out.println(ans); ;
    }

}
