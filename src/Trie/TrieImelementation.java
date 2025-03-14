package Trie;

public class TrieImelementation {

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("sameer");
        obj.insert("wadkar");
        System.out.println(obj.search("sameer"));
        obj.insert("sammy");
        obj.insert("sara");
        System.out.println(obj.startsWith("na"));
    }

}

