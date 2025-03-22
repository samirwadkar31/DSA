package SlidingWindow.OnStrings;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s= "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        int n= s.length();
        int maxsize=0;
        int[] alphabets = new int[26];

        int j=0;

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            alphabets[c - 'a']++;
            while(alphabets[c - 'a'] > 1){
                char prev = s.charAt(j);
                alphabets[prev - 'a']--;
                j++;
            }

            maxsize= Math.max(maxsize,i-j+1);
        }

        return maxsize;
    }
}
