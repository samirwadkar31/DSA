package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums= {1,2,3};
        List<List<Integer>> ans= permute(nums);

        for(List<Integer> num: ans) {
            System.out.println(num);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> tempList = new ArrayList<>();

        helper(res, tempList, nums);

        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> tempList, int[] nums){

        if(tempList.size()==nums.length){
            res.add(new ArrayList<>(tempList));
            return;
        }else{

            for(int i=0; i<nums.length; i++){
                if(tempList.contains(nums[i])){
                    continue; //skip the entire iteration
                }

                tempList.add(nums[i]);

                helper(res, tempList, nums);

                tempList.remove(tempList.size()-1);
            }

        }
    }
}
