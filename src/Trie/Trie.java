package Trie;

public class Trie {

    Node root;

    public Trie(){
        this.root= new Node();
    }

    public void insert(String word) {
        Node node= root;
        for(int i=0; i<word.length(); i++){
            char ch= word.charAt(i);
            if(node.children[ch-'a']==null){
                node.children[ch-'a']= new Node();
            }

            node= node.children[ch-'a'];
            node.count++; // longest common prefix & count words with prefix only
        }

        node.isWord= true;
    }

    public boolean search(String word) {
        Node node= root;
        for(int i=0; i<word.length(); i++){
            char ch= word.charAt(i);
            if(node.children[ch-'a']==null){
                return false;
            }

            node= node.children[ch-'a'];
        }

        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        Node node= root;
        for(int i=0; i<prefix.length(); i++){
            char ch= prefix.charAt(i);
            if(node.children[ch-'a']==null){
                return false;
            }

            node= node.children[ch-'a'];
        }

        return true;
    }

    public String longestCommonPrefix(int totalWords) {
        StringBuilder prefix = new StringBuilder();
        Node node = root;

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

    public int countWordsWithPrefix(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.children[ch - 'a'] == null) {
                return 0;
            }
            node = node.children[ch - 'a'];
        }
        return node.count;
    }
}

class Node{

    Node[] children;
    boolean isWord;
    int count;

    public Node(){
        this.children= new Node[26];
        this.isWord= false;
        this.count = 0;
    }
}