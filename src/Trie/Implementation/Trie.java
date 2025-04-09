package Trie.Implementation;

public class Trie {

    class Node{

        Node[] children;
        boolean isWord;

        public Node(){
            this.children= new Node[26];
            this.isWord= false;
        }
    }

    Node root;

    public Trie(){
        this.root= new Node();
    }

    public void insert(String word){
        Node node= root;
        for(int i=0; i<word.length(); i++){
            char ch= word.charAt(i);
            if(node.children[ch-'a']==null){
                node.children[ch-'a']= new Node();
            }

            node= node.children[ch-'a'];
        }

        node.isWord= true;
    }

    public boolean search(String word){
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

    public boolean startsWith(String word){
        Node node= root;
        for(int i=0; i<word.length(); i++){
            char ch= word.charAt(i);
            if(node.children[ch-'a']==null){
                return false;
            }

            node= node.children[ch-'a'];
        }

        return true;
    }
}

class solution{

    public static void main(String[] args) {
        Trie obj= new Trie();

        obj.insert("sameer");
        System.out.println(obj.search("ameer"));
        System.out.println(obj.startsWith("sam"));
    }
}
