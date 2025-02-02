package Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> ans= spiralOrder(matrix);
        System.out.println(ans.toString());
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res= new ArrayList<>();

        int rowStart= 0;
        int rowEnd= matrix.length-1;
        int colStart= 0;
        int colEnd= matrix[0].length-1;

        while(colStart<=colEnd && rowStart<=rowEnd){


            for(int i=colStart; i<=colEnd; i++){
                res.add(matrix[rowStart][i]);
            }
            rowStart++;

            for(int i=rowStart; i<=rowEnd; i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowStart<=rowEnd){
                for(int i=colEnd; i>=colStart; i--){
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if(colStart<=colEnd){
                for(int i=rowEnd; i>=rowStart; i--){
                    res.add(matrix[i][colStart]);
                }
            }
            colStart++;

        }
        return res;

    }
}
