package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums= {1,2,3};
        List<List<Integer>> ans= subsets(nums);

        for(List<Integer> num: ans) {
            System.out.println(num);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result= new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        helper(result, tempList, nums, 0);
        return result;
    }

    public static void helper(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start){

        result.add(new ArrayList<>(tempList));

        for(int i=start; i<nums.length; i++){
            tempList.add(nums[i]);
            helper(result, tempList, nums, i+1);
            tempList.remove(tempList.size()-1);
        }

    }
}
