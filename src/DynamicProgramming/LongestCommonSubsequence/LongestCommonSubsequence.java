package DynamicProgramming.LongestCommonSubsequence;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1= "abcde";
        String text2= "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
        System.out.println(BottomUplongestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {

        int m= text1.length();
        int n= text2.length();

        int[][] dp = new int[m][n];

        for(int[] arr: dp) Arrays.fill(arr,-1);

        return helper(text1, text2, m-1, n-1, dp);

    }

    public static int helper(String text1, String text2, int i, int j, int[][] dp){

        if(i<0 || j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j]= 1+ helper(text1, text2, i-1, j-1, dp);
        }else{
            return dp[i][j]= Math.max(helper(text1, text2, i, j-1, dp), helper(text1, text2, i-1, j, dp));
        }
    }

    //bottomUp Approach

    public static int BottomUplongestCommonSubsequence(String text1, String text2) {

        int m= text1.length();
        int n= text2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]= 1+ dp[i-1][j-1];
                }else{
                    dp[i][j]= Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
