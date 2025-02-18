package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {

        String s= "aab";
        List<List<String>> ans= partition(s);

        for(List<String> str: ans) {
            System.out.println(str);
        }

    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        helper(res, new ArrayList<>(), s, 0);

        return res;
    }

    public static void helper(List<List<String>> res, List<String> tempList, String s, int start){
        if(start == s.length())
            res.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < s.length(); i++){
                if(isPalindrome(s, start, i)){

                    tempList.add(s.substring(start, i + 1));

                    helper(res, tempList, s, i + 1);

                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public static boolean isPalindrome(String s, int left, int right){

        while(left < right){

            if(s.charAt(left++) != s.charAt(right--)) return false;
        }

        return true;
    }
}
