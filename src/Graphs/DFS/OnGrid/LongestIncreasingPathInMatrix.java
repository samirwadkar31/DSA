package Graphs.DFS.OnGrid;

public class LongestIncreasingPathInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println("Longest increasing path is: " + longestIncreasingPath(matrix));
    }

    public static int longestIncreasingPath(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        int maxPath = 0;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < matrix[0].length; j++){

                maxPath = Math.max(maxPath, dfs(matrix, i, j, directions, Integer.MIN_VALUE, dp));
            }
        }
        return maxPath;
    }

    public static int dfs(int[][] matrix, int i, int j, int[][] directions, int lastNum, int[][] dp){

        if(i < 0 || j < 0 || i >= matrix.length || j>= matrix[0].length) return 0;

        if(matrix[i][j] <= lastNum) return 0;

        if(dp[i][j] != 0) return dp[i][j];

        int count = 1;

        for(int[] dir: directions){
            int x = i + dir[0];
            int y = j + dir[1];

            count = Math.max(count, dfs(matrix, x, y, directions, matrix[i][j], dp) + 1);
        }

        return dp[i][j] = count;
    }
}
