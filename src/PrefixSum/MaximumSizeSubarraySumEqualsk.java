package PrefixSum;

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsk {
    public static void main(String[] args) {

        int[] nums= {1,-1,5,-2,3};
        int k = 4;
        int ans= maxSubArrayLen(nums,k);

        System.out.println(ans);
    }

    public static int maxSubArrayLen(int[] nums, int k) {

        int n= nums.length;
        int sum=0;
        int max= 0;

        HashMap<Integer, Integer> map= new HashMap<>();
        map.put(0,-1);

        for(int i=0; i<n; i++){
            sum+=nums[i];

            if(map.containsKey(sum-k)){
                int size= i-map.get(sum-k);
                max= Math.max(max,size);
            }

            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }

        return max;
    }
}

