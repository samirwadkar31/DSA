package Trie;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
//        if (strs.length == 0) return "";
        Trie root = new Trie();
        for (String word : strs) {
            insert(root, word);
        }
        String ans = longestCommonPrefix(root, strs.length);
        System.out.println("Longest common prefix : " + ans); ;
    }

    public static String longestCommonPrefix(Trie root, int totalWords) {
        StringBuilder prefix = new StringBuilder();
        Trie node = root;

        while (true) {
            int index = -1;
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && node.children[i].count == totalWords) {
                    if (index != -1) return prefix.toString();
                    index = i;
                }
            }
            if (index == -1) return prefix.toString();
            prefix.append((char) ('a' + index));
            node = node.children[index];
        }
    }

    public static void insert(Trie root, String word) {
        Trie node= root;
        for(int i=0; i<word.length(); i++){
            char ch= word.charAt(i);
            if(node.children[ch-'a']==null){
                node.children[ch-'a']= new Trie();
            }

            node= node.children[ch-'a'];
            node.count++; // longest common prefix & count words with prefix only
        }

        node.isWord= true;
    }

}
