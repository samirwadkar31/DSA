package PrefixSum;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;

public class ContinuousSubarraySum {
    public static void main(String[] args) {

        int[] nums= {23,2,4,6,7};
        int k=6;
        System.out.println(checkSubarraySum(nums,k));

    }

    public static boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map= new HashMap<>();
        map.put(0,-1);
        int n= nums.length;
        int sum=0;

        for(int i=0; i<n; i++){

            sum+=nums[i];
            int reminder= sum%k;
            if(map.containsKey(reminder)){
                if(i-map.get(reminder)>=2){
                    return true;
                }
            }else{
                map.put(reminder, i); // we want 1st occur as we want sub array size >=2 do not update reminder index
            }
        }
        return false;
    }
}
