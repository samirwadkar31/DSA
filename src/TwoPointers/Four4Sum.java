package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four4Sum {
    public static void main(String[] args) {
        int[] nums= {1,0,-1,0,-2,2};
        int target=0;
        List<List<Integer>> res= fourSum(nums, target);
        System.out.println(res);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n= nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<>();

        for(int i=0; i<n-3; i++){

            if(i>0 && nums[i]==nums[i-1]) continue;

            for(int j=i+1; j<n-2; j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;

                int start= j+1;
                int end= n-1;

                while(start<end){

                    long sum= (long)nums[i]+nums[j]+nums[start]+nums[end];
                    if(sum==target){

                        res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));

                        while(start<end && nums[start]==nums[start+1]) start++;
                        while(start<end && nums[end]==nums[end-1]) end--;

                        start++;
                        end--;
                    }else if(sum<target){
                        start++;
                    }else{
                        end--;
                    }
                }
            }
        }
        return res;
    }
}
