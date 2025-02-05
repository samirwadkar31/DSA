package DynamicProgramming.MatrixGrid;

import java.util.Arrays;

public class UniquePaths1 {
    public static void main(String[] args) {
        int m=3;
        int n=7;
        System.out.println(uniquePaths(m,n));
        System.out.println(BottomUpUniquePaths(m,n));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int[] arr: dp) Arrays.fill(arr, -1);

        return helper(0, 0, m, n, dp);
    }

    public static int helper(int i, int j, int m, int n, int[][] dp){

        if(i==m-1 && j==n-1) return 1;

        if(i>=m || j>=n ) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int right= helper(i, j+1, m, n, dp);
        int down= helper(i+1, j, m, n, dp);

        return dp[i][j]= right+down;
    }

    // Bottom Up Approach

    public static int BottomUpUniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for(int col=0; col<n; col++) dp[0][col]=1;

        for(int row=0; row<m; row++) dp[row][0]=1;

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j]= dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
