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

        int[][] directions = {{1,0}, {0,1}};

        for(int[] arr: dp) Arrays.fill(arr, -1);

        return helper(0, 0, m, n, dp, directions);
    }

    public static int helper(int i, int j, int m, int n, int[][] dp, int[][] directions){

        if(i>=m || j>=n ) return 0;

        if(i==m-1 && j==n-1) return 1;

        if(dp[i][j]!=-1) return dp[i][j];

        int count = 0;

        for(int[] dir: directions){
            int x = i + dir[0];
            int y = j + dir[1];

            count += helper(x, y, m, n, dp, directions);
        }

        return dp[i][j]= count;
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
