package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    public static void main(String[] args) {
        int[] nums= {1,1,2};
        List<List<Integer>> ans= permuteUnique(nums);

        for(List<Integer> num: ans) {
            System.out.println(num);
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> tempList = new ArrayList<>();

        boolean[] used= new boolean[nums.length];

        helper(res, tempList, used, nums);

        return res;

    }

    public static void helper(List<List<Integer>> res, List<Integer> tempList, boolean[] used, int[] nums){

        if(tempList.size()==nums.length){
            res.add(new ArrayList<>(tempList));
            return;
        }else{

            for(int i=0; i<nums.length; i++){
                if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1]){
                    continue; //skip the entire iteration
                }
                if(used[i]==true){
                    continue;
                }
                used[i]=true;
                tempList.add(nums[i]);

                helper(res, tempList, used, nums);

                used[i]= false;
                tempList.remove(tempList.size()-1);

            }

        }
    }
}
