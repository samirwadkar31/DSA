package SlidingWindow.OnStrings;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println("Is permutation of s1 present in s2?: " + checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();
        int requiredCount = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            requiredCount++;
        }

        int j = 0;

        for(int i = 0; i < m; i++){
            char ch = s2.charAt(i);

            if(map.containsKey(ch) && map.get(ch) > 0){
                requiredCount--;
            }

            map.put(ch, map.getOrDefault(ch, 0) - 1);


            while(requiredCount == 0){

                char jChar = s2.charAt(j);

                if(i - j + 1 == n) return true;

                map.put(jChar, map.getOrDefault(jChar, 0) + 1);

                if(map.get(jChar) > 0){
                    requiredCount++;
                }

                j++;
            }

        }

        return false;
    }
}
