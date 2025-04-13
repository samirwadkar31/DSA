package DynamicProgramming.OnStrings;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        System.out.println("Minimum number of operations required: " + minDistanceTopDown(word1, word2));
        System.out.println("Minimum number of operations required: " + minDistanceBottomUp(word1, word2));

    }

    public static int minDistanceTopDown(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];
        for(int[] arr: dp) Arrays.fill(arr, -1);

        return helper(word1, word2, n, m, dp);
    }

    public static int helper(String word1, String word2, int i, int j, int[][] dp){

        if(i == 0){
            return j; //need to insert extra
        }
        if(j == 0){
            return i; //need to delete extra
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i-1) == word2.charAt(j-1)){
            return dp[i][j] = helper(word1, word2, i - 1, j - 1, dp);
        }

        int insert = 1 + helper(word1, word2, i, j - 1, dp);
        int delete = 1 + helper(word1, word2, i - 1, j, dp);
        int replace = 1 + helper(word1, word2, i - 1, j - 1, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }

    public static int minDistanceBottomUp(String word1, String word2){
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){

                if(i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
            }
        }

       return dp[n][m];
    }
}
