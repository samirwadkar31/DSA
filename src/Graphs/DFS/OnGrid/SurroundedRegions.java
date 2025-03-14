package Graphs.DFS.OnGrid;

public class SurroundedRegions {

    static int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X','X'},
                {'X','X','O','O','X'},
                {'X','X','X','O','X'},
                {'X','X','O','X','X'}};

        solve(board);

        for(char[] bd: board){
            System.out.println(bd);
        }
    }

    public static void solve(char[][] board) {

        //checking if first & last row of board has O, if yes then calling dfs and converting 'O' to different Char 'V'
        for(int j=0; j<board[0].length; j++){
            if(board[0][j]=='O'){
                dfs(0, j, board);
            }

            if(board[board.length-1][j]=='O'){
                dfs(board.length-1, j, board);
            }
        }
        //checking if first & last col of board has O, if yes then calling dfs and converting 'O' to different Char 'V'
        for(int i=0; i<board.length; i++){
            if(board[i][0]=='O'){
                dfs(i, 0, board);
            }

            if(board[i][board[0].length-1]=='O'){
                dfs(i, board[0].length-1, board);
            }
        }

        // Again in entire board, converting untouched 'O's to 'X' & 'V's to 'O'

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='V'){
                    board[i][j]='O';
                }
            }
        }

    }

    public static void dfs(int i, int j, char[][] board){

        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!='O'){
            return;
        }

        board[i][j]='V';

        for(int[] dir: directions){
            dfs(i+dir[0], j+dir[1], board);
        }

    }
}
