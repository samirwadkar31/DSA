package PrefixSum;

import java.util.HashMap;

public class SubarraySumsDivisiblebyK {
    public static void main(String[] args) {
        int[] nums= {2,-6,3,1,2,8,2,1};
        int k=7;
        System.out.println("SubarraySumsDivisiblebyK "+subarraysDivByK(nums,k));
    }
    public static int subarraysDivByK(int[] nums, int k) {

        //[2,-6,3,1,2,8,2,1] k=7
        //sum 2,-4,-1,0,2,10,12,13
        //rem 2,-4,-1,0,2,3,5,6  here it will fail if we don't add the edge case
        //rem 2, 3, 6,0,2,3,5,6   with edge case
        HashMap<Integer, Integer> map= new HashMap<>();
        map.put(0,1);
        int n= nums.length;
        int sum=0;
        int count=0;

        for(int i=0; i<n; i++){
            sum+=nums[i];

            int reminder= sum%k;

            if(reminder<0){
                reminder+=k;
            }

            if(map.containsKey(reminder)){
                count+=map.get(reminder);
            }

            map.put(reminder, map.getOrDefault(reminder,0)+1);
        }
        return count;
    }
}
