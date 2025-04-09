package BinarySearch;

public class SearchA2DMatrix1 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10,11,16,20},
                {23,30,34,60}};
        int target = 16;

        System.out.println("Target present in 2D matrix?: " + searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        int start = 0;
        int end = m-1;

        int row = -1;

        while(start <= end){

            int mid = start + (end - start)/2;

            if(matrix[mid][0] <= target && target <= matrix[mid][m-1]){
                row = mid;
                break;
            }else if(matrix[mid][0] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }

        }

        if(row == -1) return false;

        start=0;
        end= m-1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(matrix[row][mid] == target){
                return true;
            }else if(matrix[row][mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
}
