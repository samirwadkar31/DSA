package PrefixSum;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums= {3, 4, 7, 2, -3, 1, 4, 2, 1};
        int k=7;
        // there are total 6 subarrays whose sum equals k=7
        System.out.println("SubarraySumEqualsK "+ subarraySum(nums,k));

    }

    public static int subarraySum(int[] nums, int k) {

        //[3, 4, 7, 2, -3, 1, 4, 2, 1]
//PFXSUM 0 3, 7, 14, 16, 13, 14,18,20,21
        if(nums.length==1 &nums[0]==k){
            return 1;
        }
        HashMap<Integer, Integer> map= new HashMap<>();
        map.put(0,1);
        int n=nums.length;
        int sum=0;
        int count=0;

        for(int i=0; i<n; i++){
            sum=sum+nums[i];

            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
