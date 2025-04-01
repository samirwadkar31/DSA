package DynamicProgramming.MatrixGrid;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid= {{1,3,1},{1,5,1}, {4,2,1}};
        System.out.println(minPathSum(grid));
        System.out.println(BottomUpMinPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] directions = {{1,0}, {0,1}};
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int minSum = dfs(grid, 0, 0, directions, n, m, dp);

        return minSum;

    }

    public static int dfs(int[][] grid, int i, int j, int[][] directions, int n, int m, int[][] dp){

        if(i >= n || j >= m) return Integer.MAX_VALUE;
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        if(i == n-1 && j == m -1) return grid[i][j];

        int sum = grid[i][j];
        int minAnswer = Integer.MAX_VALUE;

        for(int[] dir: directions){
            int x = i + dir[0];
            int y = j + dir[1];

            minAnswer = Math.min(minAnswer, dfs(grid, x, y, directions, n, m, dp));
        }
        sum += minAnswer;

        return dp[i][j] = sum;
    }

    // bottom up Approach

    public static int BottomUpMinPathSum(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0]= grid[0][0];

        for(int col=1; col<n; col++) dp[0][col]=dp[0][col-1]+ grid[0][col];

        for(int row=1; row<m; row++) dp[row][0]=dp[row-1][0]+ grid[row][0];

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j]=grid[i][j]+ Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];

    }
}
