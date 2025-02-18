package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n= 4;
        int k=2;
        List<List<Integer>> ans= combine(n, k);

        for(List<Integer> num: ans) {
            System.out.println(num);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList= new ArrayList<>();
        helper(res, tempList,n, k, 1);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> tempList, int n, int k, int start){

        if(tempList.size()==k){
            res.add(new ArrayList<>(tempList));
            return;
        }else{
            for(int i=start; i<=n; i++){
                tempList.add(i);
                helper(res, tempList,n, k, i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
