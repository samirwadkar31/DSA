package Matrix;
import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {

        HashSet<String> set= new HashSet<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){

                if(board[i][j]!='.'){
                    char curr = board[i][j];

                    String rowPresence = "row" + i + curr;
                    String colPresence = "col" + j + curr;
                    String boxPresence = "box" + i/3 + j/3 + curr;

                    if(!set.contains(rowPresence)){
                        set.add(rowPresence);
                    }else{
                        return false;
                    }

                    if(!set.contains(colPresence)){
                        set.add(colPresence);
                    }else{
                        return false;
                    }

                    if(!set.contains(boxPresence)){
                        set.add(boxPresence);
                    }else{
                        return false;
                    }
                }
            }
        }

        return true;

    }
}
