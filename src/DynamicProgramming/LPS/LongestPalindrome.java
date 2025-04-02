package DynamicProgramming.LPS;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abccccdd";

        System.out.println("Longest Palindrome length is: " + longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {

        int n = s.length();

        Set<Character> set = new HashSet<>();
        int ans = 0;

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
            }else{
                set.remove(ch);
                ans += 2;
            }
        }

        return set.isEmpty() ? ans: ans + 1;
    }
}
