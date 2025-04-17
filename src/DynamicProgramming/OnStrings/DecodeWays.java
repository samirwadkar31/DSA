package DynamicProgramming.OnStrings;

import java.util.Arrays;

public class DecodeWays {

    public static void main(String[] args) {

        String s = "226";
        System.out.println("Total Decoded Ways: " + numDecodingsTopDown(s));
        System.out.println("Total Decoded Ways: " + numDecodingsBottomUp(s));

    }

    public static int numDecodingsTopDown(String s) {
        int n = s.length();
        int[] dp = new int[101];
        Arrays.fill(dp, -1);

        return helper(s, n, 0, dp);
    }

    public static int helper(String s, int n, int i, int[] dp){

        if(i == n) return 1;

        if(s.charAt(i) == '0') return 0;

        if(dp[i] != -1) return dp[i];

        //single char

        int count = helper(s, n, i + 1, dp);

        // two chars

        if(i + 1 < n){

            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')){
                count += helper(s, n, i + 2, dp);
            }
        }


        return dp[i] = count;
    }

    public static int numDecodingsBottomUp(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        dp[n] = 1;

        for(int i = n - 1; i >=0; i--){

            if(s.charAt(i) == '0'){
                dp[i] = 0;
            }else{
                dp[i] = dp[i+1];

                if(i + 1 < n){
                    if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')){
                        dp[i] += dp[i+2];
                    }
                }
            }
        }


        return dp[0];
    }
}
