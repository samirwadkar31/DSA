package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public static void main(String[] args) {
        int[] nums= {1,2,2};
        List<List<Integer>> ans= subsetsWithDup(nums);

        for(List<Integer> num: ans) {
            System.out.println(num);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList= new ArrayList<>();

        helper(res, tempList, nums, 0);

        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start){
        res.add(new ArrayList<>(tempList));

        for(int i=start; i<nums.length; i++){

            if(i>start && nums[i]==nums[i-1]){
                continue; //skip duplicate
            }

            tempList.add(nums[i]);

            helper(res, tempList, nums, i+1);

            tempList.remove(tempList.size()-1);
        }
    }
}
