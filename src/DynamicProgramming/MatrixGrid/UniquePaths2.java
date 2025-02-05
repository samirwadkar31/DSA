package DynamicProgramming.MatrixGrid;

import java.util.Arrays;

public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] obstacleGrid= {{0,0,0}, {0,1,0}, {0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        System.out.println(BottomUpUniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m= obstacleGrid.length;
        int n= obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1) return 0;

        int[][] dp= new int[m][n];

        for(int[] arr: dp) Arrays.fill(arr, -1);

        return helper(obstacleGrid, 0, 0, m, n, dp);

    }

    public static int helper(int[][] obstacleGrid, int i, int j, int m, int n, int[][] dp){

        if(i==m-1 && j==n-1) return 1;

        if(i>=m || j>=n || obstacleGrid[i][j]==1) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int right= helper(obstacleGrid, i, j+1, m, n, dp);
        int down= helper(obstacleGrid, i+1, j, m, n, dp);

        return dp[i][j]= right+down;
    }

    // bottom Up Approach

    public static int BottomUpUniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n= obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1) return 0;

        int[][] dp = new int[m][n];

        for(int col=0; col<n; col++){
            if(obstacleGrid[0][col]==1){
                while(col<n){
                    dp[0][col]=0;
                    col++;
                }
            }else{
                dp[0][col]=1;
            }
        }

        for(int row=0; row<m; row++){
            if(obstacleGrid[row][0]==1){
                while(row<m){
                    dp[row][0]=0;
                    row++;
                }
            }else{
                dp[row][0]=1;
            }
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j]==1) dp[i][j]=0;
                else dp[i][j]= dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
