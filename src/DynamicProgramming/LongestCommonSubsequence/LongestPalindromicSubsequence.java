package DynamicProgramming.LongestCommonSubsequence;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s= "bbbab"; // output 4 bbbb
        System.out.println(longestPalindromeSubseq(s));
    }

    public static int longestPalindromeSubseq(String s) {

        int[][] dp= new int[s.length()][s.length()];

        for(int[] arr: dp) Arrays.fill(arr, -1);

        return helper(s, 0, s.length()-1, dp);
    }

    public static int helper(String s, int i, int j, int[][] dp){

        if(i>j) return 0;

        if(i==j) return 1;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]= 2+ helper(s, i+1, j-1, dp);
        }else{
            return dp[i][j]= Math.max(helper(s, i, j-1, dp), helper(s, i+1,j, dp));
        }
    }
}
