package Trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {

    public static void main(String[] args) {
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};

        List<String> ans = findWords(board, words);

        System.out.println("Words found : " + ans);
    }
    public static List<String> findWords(char[][] board, String[] words) {

        int m = board.length;
        int n = board[0].length;
        int len = words.length;

        int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        List<String> res = new ArrayList<>();

        Trie root = new Trie();

        for(int i = 0; i < len; i++){
            insertWord(root, words[i]);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(root.children[board[i][j] - 'a'] != null){
                    dfs(root, board, i, j, directions, res);
                }
            }
        }
        return res;
    }

    public static void dfs(Trie node, char[][] board, int i, int j, int[][] directions, List<String> res){

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#'){
            return;
        }

        char temp = board[i][j];
        node = node.children[temp -'a'];
        if(node == null) return;

        board[i][j] = '#';

        if(node.isWord){
            res.add(node.word);
            node.isWord = false;
        }


        for(int[] dir: directions){
            int x = i + dir[0];
            int y = j + dir[1];

            dfs(node, board, x, y, directions, res);
        }

        board[i][j] = temp;
    }

    public static void insertWord(Trie root, String s){
        Trie node = root;
        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);
            if(node.children[ch -'a'] == null){
                node.children[ch -'a'] = new Trie();
            }
            node = node.children[ch -'a'];
        }

        node.word = s;
        node.isWord = true;
    }
}

