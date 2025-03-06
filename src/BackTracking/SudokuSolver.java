package BackTracking;

public class SudokuSolver {
    public static void main(String[] args) {


        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
    }

    public static void solveSudoku(char[][] board) {
        System.out.println(helper(board));
    }

    public static boolean helper(char[][] board){

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){

                if(board[i][j]=='.'){

                    for(char k = '1'; k <= '9'; k++){

                        if(isValidPlacement(board, i, j, k)){

                            board[i][j]= k;

                            if(helper(board)){
                                return true;
                            }

                            board[i][j]= '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidPlacement(char[][] board, int i, int j, char k){

        for(int row = 0; row < 9; row++) if (board[row][j] == k) return false;

        for(int col = 0; col < 9; col++) if (board[i][col] == k) return false;

        int boxRowStart = (i / 3) * 3, boxColStart = (j / 3) * 3;

        for(int row = boxRowStart; row < boxRowStart + 3; row++){
            for (int col = boxColStart; col < boxColStart + 3; col++){
                if (board[row][col] == k) return false;
            }
        }
        return true;
    }
}
