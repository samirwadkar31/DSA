package DynamicProgramming.LCS;

import java.util.Arrays;

public class DeleteOperationForTwoStrings {

    public static void main(String[] args) {

        String word1 = "sea"; // heat
        String word2 = "eat"; // hit
        System.out.println("Minimum Delete Operation To Make Two Strings Equal: " + minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] arr: dp) Arrays.fill(arr, -1);

        return n + m - helper(word1, word2, n, m, dp);
    }

    public static int helper(String word1, String word2, int i, int j, int[][] dp){

        if(i == 0 || j == 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i - 1) == word2.charAt(j - 1)){
            return dp[i][j] = 2 + helper(word1, word2, i - 1, j - 1, dp);
        }else{

            return dp[i][j] = Math.max(helper(word1, word2, i, j - 1, dp), helper(word1, word2, i - 1, j, dp));
        }

    }
}
