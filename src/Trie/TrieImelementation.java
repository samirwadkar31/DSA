package Trie;

public class TrieImelementation {

    public static void main(String[] args) {

        String[] strs = {"sameer","sun","sam", "education"};

        Trie root = new Trie();
        for (String word : strs) {
            insert(root, word);
        }

        System.out.println(search(root, "sameer"));
        System.out.println(search(root, "sam"));
        System.out.println(search(root, "dog"));
        System.out.println(search(root, "education"));

        System.out.println(startsWith(root,"sa"));
        System.out.println(startsWith(root,"sam"));
        System.out.println(startsWith(root,"edu"));

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

    public static boolean search(Trie root, String word) {
        Trie node= root;
        for(int i=0; i<word.length(); i++){
            char ch= word.charAt(i);
            if(node.children[ch-'a']==null){
                return false;
            }

            node= node.children[ch-'a'];
        }

        return node.isWord;
    }

    public static boolean startsWith(Trie root, String prefix) {
        Trie node= root;
        for(int i=0; i<prefix.length(); i++){
            char ch= prefix.charAt(i);
            if(node.children[ch-'a']==null){
                return false;
            }

            node= node.children[ch-'a'];
        }

        return true;
    }

}

