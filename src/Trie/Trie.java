package Trie;

//public class Trie {
//
//    Node root;
//
//    public Trie(){
//        this.root= new Node();
//    }
//
//    public void insert(String word) {
//        Node node= root;
//        for(int i=0; i<word.length(); i++){
//            char ch= word.charAt(i);
//            if(node.children[ch-'a']==null){
//                node.children[ch-'a']= new Node();
//            }
//
//            node= node.children[ch-'a'];
//            node.count++; // longest common prefix & count words with prefix only
//        }
//
//        node.isWord= true;
//    }
//
//    public boolean search(String word) {
//        Node node= root;
//        for(int i=0; i<word.length(); i++){
//            char ch= word.charAt(i);
//            if(node.children[ch-'a']==null){
//                return false;
//            }
//
//            node= node.children[ch-'a'];
//        }
//
//        return node.isWord;
//    }
//
//    public boolean startsWith(String prefix) {
//        Node node= root;
//        for(int i=0; i<prefix.length(); i++){
//            char ch= prefix.charAt(i);
//            if(node.children[ch-'a']==null){
//                return false;
//            }
//
//            node= node.children[ch-'a'];
//        }
//
//        return true;
//    }
//
//
//    public int countWordsWithPrefix(String prefix) {
//        Node node = root;
//        for (int i = 0; i < prefix.length(); i++) {
//            char ch = prefix.charAt(i);
//            if (node.children[ch - 'a'] == null) {
//                return 0;
//            }
//            node = node.children[ch - 'a'];
//        }
//        return node.count;
//    }
//}

public class Trie{

    Trie[] children;
    boolean isWord;
    int count;
    String word;

    public Trie(){
        this.children= new Trie[52]; // 26 for lowercase letters | 52 for both lower and upper case | 10 for 0-9 digits
        this.isWord= false;
        this.count = 0;
        this.word = "";
    }
}

