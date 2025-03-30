package Matrix;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}};

        rotate(matrix);

        for(int[] image: matrix){
            for(int num: image){
                System.out.print(num + "      ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {

        int n= matrix.length;

        //transpose of the matrix
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){

                int temp= matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]=temp;

            }
        }

        //swaping columns
        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){
                int temp2= matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]= temp2;
            }
        }

    }
}
