package SlidingWindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s= "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        int n= s.length();
        int maxsize=0;

        HashSet<Character> set= new HashSet<>();

        int j=0;

        for(int i=0; i<n; i++){

            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(j));
                j++;
            }

            set.add(s.charAt(i));
            maxsize= Math.max(maxsize,i-j+1);
        }

        return maxsize;
    }
}
