package BinarySearch;

public class SearchA2DMatrix2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};
        int target = 17;

        // TC: m*log(n)
        System.out.println("Target present in 2D matrix?: " + searchMatrix(matrix, target));
        //TC: m + n
        System.out.println("Target present in 2D matrix?: " + searchMatrixTrick(matrix, target));
    }

    //TC: m + n

    public static boolean searchMatrixTrick(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m - 1;

        while(row < n && col >= 0){

            if(matrix[row][col] == target){
                return true;
            }else if(target < matrix[row][col]){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
    // TC: m*log(n)
    public static boolean searchMatrix(int[][] matrix, int target) {

        for(int i=0; i<matrix.length; i++){
            if(findTarget(matrix[i], target)){
                return true;
            }
        }
        return false;
    }

    public static boolean findTarget(int[] row, int target){

        int start = 0;
        int end = row.length - 1;

        while(start<=end){

            int mid= start+(end-start)/2;

            if(row[mid]==target){
                return true;
            }else if(row[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }

        return false;
    }
}
