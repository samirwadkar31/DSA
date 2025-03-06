package SlidingWindow.OnStrings;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {

        String s= "ADOBECODEBANC";
        String t= "ABC";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        int n= s.length(), m= t.length();
        if(m>n) return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<m; i++){
            char tcurr= t.charAt(i);
            map.put(tcurr, map.getOrDefault(tcurr,0)+1);
        }

        int requiredCount= m;
        int i=0, j=0, start=0, minSize=Integer.MAX_VALUE;

        while(i<n){
            char scurr= s.charAt(i);

            if(map.containsKey(scurr) && map.get(scurr)>0){
                requiredCount--;
            }

            map.put(scurr, map.getOrDefault(scurr, 0)-1);

            while(requiredCount==0){

                int size= i-j+1;

                if(size<minSize){
                    minSize=size;
                    start=j;
                }

                char jcurr= s.charAt(j);

                map.put(jcurr, map.getOrDefault(jcurr, 0)+1);

                if(map.get(jcurr)>0){
                    requiredCount++;
                }
                j++;
            }
            i++;
        }
        return minSize== Integer.MAX_VALUE? "": s.substring(start, start+minSize);
    }
}
