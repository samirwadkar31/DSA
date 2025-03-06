package SlidingWindow.OnStrings;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args){
        String s= "abcbac";
        String t= "abc";
        // output [0, 2, 3]
        List<Integer> ans= findAnagrams(s,t);
        System.out.println(ans);
    }

    public static List<Integer> findAnagrams(String s, String t) {
        List<Integer> anagrams = new ArrayList<>();
        int n = s.length(), m = t.length();

        if(m > n) return anagrams;

        int[] anagram = new int[26];

        for(char c : t.toCharArray()){
            anagram[c - 'a'] += 1;
        }

        int requiredCount = m;

        int end = 0, start =0;

        for(; end < n; end += 1){

            char c = s.charAt(end);

            if(anagram[c - 'a'] > 0 ){
                requiredCount -= 1;
            }
            anagram[c - 'a'] -= 1;

            while(requiredCount == 0){
                if(m == end - start + 1){
                    anagrams.add(start);
                }

                char c1 = s.charAt(start);
                start += 1;

                anagram[c1 - 'a'] += 1;
                if(anagram[c1 - 'a'] > 0 ){
                    requiredCount += 1;
                }

            }

        }

        return anagrams;
    }
}
