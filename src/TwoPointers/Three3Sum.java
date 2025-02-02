package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Three3Sum {
    public static void main(String[] args) {
        int[] nums= {-1,0,1,2,-1,-4};
        List<List<Integer>> res= threeSum(nums);
        System.out.println(res.toString());
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int n= nums.length;

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        HashSet<List<Integer>> set = new HashSet<>();

        for(int i=0; i<n-2; i++){
            int start=i+1;
            int end= n-1;

            while(start<end){
                int sum= nums[i]+nums[start]+nums[end];
                if(sum==0){
                    set.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                }else if(sum<0){
                    start++;
                }else{
                    end--;
                }
            }
        }

        ans.addAll(set);

        return ans;

    }
}
