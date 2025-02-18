package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates= {10,1,2,7,6,1,5};
        int target= 8;
        List<List<Integer>> ans= combinationSum2(candidates, target);

        for(List<Integer> num: ans) {
            System.out.println(num);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        helper(res, tempList, candidates, target, 0);
        return res;

    }

    public static void helper(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int target, int start ){

        if(target==0){
            res.add(new ArrayList<>(tempList));
            return;
        }

        if(target<0){
            return;
        }

        for(int i=start; i<candidates.length; i++){
            if(i>start && candidates[i]==candidates[i-1]){
                continue; //skip the duplicates
            }
            tempList.add(candidates[i]);
            helper(res, tempList, candidates, target-candidates[i], i+1);
            tempList.remove(tempList.size()-1);
        }

    }
}
