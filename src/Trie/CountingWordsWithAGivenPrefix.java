package Trie;

public class CountingWordsWithAGivenPrefix {
    public static void main(String[] args) {
        String[] words = {"pay","attention","practice","attend"};
        String pref = "at";

//        Input: words = ["leetcode","win","loops","success"], pref = "code"
//        Output: 0

        Trie root = new Trie();
        for (String word : words) {
            insert(root, word);
        }

        System.out.println("Prefix count : " + countWordsWithPrefix(root, pref));

    }

    public static int countWordsWithPrefix(Trie root, String prefix) {
        Trie node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.children[ch - 'a'] == null) {
                return 0;
            }
            node = node.children[ch - 'a'];
        }
        return node.count;
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
