package DynamicProgramming.MatrixGrid;

import java.util.Arrays;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {2,1,3},
                {6,5,4},
                {7,8,9}};

        System.out.println("Minimum falling path sum is: " + minFallingPathSum(matrix));
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] directions = {{1,-1}, {1,0}, {1,1}};
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int minSum = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){

            minSum = Math.min(minSum, dfs(matrix, 0, i, directions, n, m, dp));

        }
        return minSum;
    }

    private static int dfs(int[][] matrix, int i, int j, int[][] directions, int n, int m, int[][] dp){

        if(i < 0 || j < 0 || i >= n || j >= m) return Integer.MAX_VALUE;
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        if(i == n-1) return matrix[i][j];

        int sum = matrix[i][j];
        int minAnswer = Integer.MAX_VALUE;

        for(int[] dir: directions){
            int x = i + dir[0];
            int y = j + dir[1];

            minAnswer = Math.min(minAnswer, dfs(matrix, x, y, directions, n, m, dp));
        }
        sum += minAnswer;

        return dp[i][j] = sum;
    }
}
