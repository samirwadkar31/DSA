package DynamicProgramming.MatrixGrid;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid= {{1,3,1},{1,5,1}, {4,2,1}};
        System.out.println(minPathSum(grid));
        System.out.println(BottomUpMinPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;

        int[][] dp = new int[m][n];

        for(int[] arr: dp) Arrays.fill(arr, -1);

        return helper(grid, 0, 0, m, n, dp);

    }

    public static int helper(int[][] grid, int i, int j, int m, int n, int[][] dp){

        if(i==m-1 && j==n-1) return grid[i][j];

        if(i>=m || j>=n) return Integer.MAX_VALUE;

        if(dp[i][j]!=-1) return dp[i][j];

        int right= helper(grid, i, j+1, m, n, dp);
        int down= helper(grid, i+1, j, m, n, dp);

        return dp[i][j]= grid[i][j]+ Math.min(right, down);
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
