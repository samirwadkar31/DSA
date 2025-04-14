package DynamicProgramming.OnStrings;

import java.util.Arrays;

public class DistinctSubsequences {
    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        // output: 5
        // babgbag
        // babgbag
        // babgbag
        // babgbag
        // babgbag

        System.out.println("Distinct Subsequences count : " + numDistinct(s, t));
    }

    public static int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        if(m > n) return 0;

        int[][] dp = new int[n][m];
        for(int[] arr: dp) Arrays.fill(arr, -1);

        return helper(s, t, n - 1, m - 1, dp);
    }

    public static int helper(String s, String t, int i, int j, int[][] dp){

        if(j < 0) return 1;
        if(i < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = helper(s, t, i - 1, j - 1, dp) + helper(s, t, i - 1, j, dp);
        }else{
            return dp[i][j] = helper(s, t, i - 1, j, dp);
        }
    }
}
