package SlidingWindow.OnStrings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    public static void main(String[] args) {
        String s = "aabbcccaa";
        int k = 2;

        System.out.println("Max length substring: " + longestSubWithKdistChars(s, k));
    }

    public static String longestSubWithKdistChars(String s, int k){

        if(s.equals("")) return "";
        if(k == 0) return "";

        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        int j = 0;
        int i = 0;

        int maxLength = -1;
        String ans = "";

        while(i < n){

            char curr = s.charAt(i);

            map.put(curr, map.getOrDefault(curr, 0) + 1);

            while(map.size()> k){
                char prev = s.charAt(j);
                map.put(prev, map.getOrDefault(prev, 0) - 1);

                if(map.get(prev) == 0) map.remove(prev);

                j++;
            }


            if(maxLength <= i - j + 1){
                maxLength = Math.max(maxLength, i - j + 1);

                ans = s.substring(j, i+1);
            }

            i++;

        }

        return ans;
    }
}
