package Trie;

public class WordSearch1 {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String s = "ABCCED";

        System.out.println("Is word present in the grid: " + exist(board, s));
    }

    public static boolean exist(char[][] board, String s) {
        int m = board.length;
        int n = board[0].length;
        int len = s.length();

        int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};

        Trie root = new Trie();

        insertWord(root, s);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(root.children[getIndex(board[i][j])] != null && dfs(root, board, i, j, directions)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(Trie node, char[][] board, int i, int j, int[][] directions){

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#'){
            return false;
        }

        char temp = board[i][j];
        node = node.children[getIndex(temp)];
        if(node == null) return false;

        board[i][j] = '#';

        if(node.isWord){
            return true;
        }


        for(int[] dir: directions){
            int x = i + dir[0];
            int y = j + dir[1];

            if(dfs(node, board, x, y, directions)){
                return true;
            }
        }

        board[i][j] = temp;

        return false;
    }

    public static int getIndex(char ch) {
        return Character.isLowerCase(ch) ? ch - 'a' : ch - 'A' + 26;
    }


    public static void insertWord(Trie root, String s){
        Trie node = root;
        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);
            if(node.children[getIndex(ch)] == null){
                node.children[getIndex(ch)] = new Trie();
            }
            node = node.children[getIndex(ch)];
        }

        node.word = s;
        node.isWord = true;
    }
}
