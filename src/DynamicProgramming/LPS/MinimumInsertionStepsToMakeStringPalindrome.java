package DynamicProgramming.LPS;

public class MinimumInsertionStepsToMakeStringPalindrome {
    public static void main(String[] args) {
        String s = "leetcode";

        System.out.println("Minimum insertions required: " + minInsertionsBottomUp(s));
    }

    public static int minInsertionsBottomUp(String s) {

        int n = s.length();
        String sReverse = reverseString(s);

        int ans = n - lcs(s, sReverse);

        return ans;
    }

    public static int lcs(String s, String sReverse){

        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(s.charAt(i-1)==sReverse.charAt(j-1)){
                    dp[i][j]= 1+ dp[i-1][j-1];
                }else{
                    dp[i][j]= Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[n][n];
    }

    public static String reverseString(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
