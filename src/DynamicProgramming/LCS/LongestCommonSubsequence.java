package DynamicProgramming.LCS;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1= "abcde";
        String text2= "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
        System.out.println(BottomUplongestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {

        int n= text1.length();
        int m= text2.length();

        int[][] dp = new int[n+1][m+1];

        for(int[] arr: dp) Arrays.fill(arr,-1);

        return helper(text1, text2, n, m, dp);

    }

    public static int helper(String text1, String text2, int i, int j, int[][] dp){

        if(i == 0 || j == 0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(text1.charAt(i-1) == text2.charAt(j-1)){
            return dp[i][j]= 1 + helper(text1, text2, i-1, j-1, dp);
        }else{
            return dp[i][j]= Math.max(helper(text1, text2, i, j-1, dp), helper(text1, text2, i-1, j, dp));
        }
    }

    //bottomUp Approach

    public static int BottomUplongestCommonSubsequence(String text1, String text2) {

        int n= text1.length();
        int m= text2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]= 1+ dp[i-1][j-1];
                }else{
                    dp[i][j]= Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }
}
