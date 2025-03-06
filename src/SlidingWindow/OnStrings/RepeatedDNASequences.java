package SlidingWindow.OnStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
    public static void main(String[] args) {
        String s= "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> res= findRepeatedDnaSequences(s);
        System.out.println(res);
    }

    public static List<String> findRepeatedDnaSequences(String s) {

        Set seen = new HashSet(), repeated = new HashSet();

        List<String> ans= new ArrayList<>();

        for(int i = 0; i + 9 < s.length(); i++) {

            String ten = s.substring(i, i + 10);

            if(!seen.contains(ten)){
                seen.add(ten);
            }else{
                repeated.add(ten);
            }
        }

        ans.addAll(repeated);

        return ans;

    }
}
