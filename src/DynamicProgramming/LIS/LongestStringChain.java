package DynamicProgramming.LIS;

import java.util.Arrays;

public class LongestStringChain {
    public static void main(String[] args) {

        String[] words ={"a","b","ba","bca","bda","bdca"};

        System.out.println("Longest String Chain Length is: " + longestStrChain(words));
    }

    public static int longestStrChain(String[] words) {

        int n = words.length;

        Arrays.sort(words, (a,b)-> a.length() - b.length());

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int longestChain = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){

                if(isValid(words[j], words[i]) && dp[j] + 1 > dp[i]){

                    dp[i] = dp[j] + 1;

                }
            }

            longestChain = Math.max(longestChain, dp[i]);
        }

        return longestChain;

    }

    public static boolean isValid(String s, String t){

        int n = s.length();
        int m = t.length();


        if(m != n + 1) return false;

        boolean flag = false;
        int i = 0;
        int j = 0;

        while(i < m && j < n){
            char schar = s.charAt(j);
            char tchar = t.charAt(i);

            if(schar == tchar){
                i++;
                j++;
            }else if(!flag){
                flag = true;
                i++;
            }else{
                return false;
            }
        }

        return true;
    }
}
