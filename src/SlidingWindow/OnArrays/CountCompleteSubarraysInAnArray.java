package SlidingWindow.OnArrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountCompleteSubarraysInAnArray {
    public static void main(String[] args) {
        int[] nums = {1,3,1,2,2};

        System.out.println(" Count Of Complete Subarrays in an Array is: " + countCompleteSubarrays(nums));
    }

    public static int countCompleteSubarrays(int[] nums) {

        int n = nums.length;
        int count  = 0;

        Set<Integer> distinctSet = new HashSet<>();

        for(int i = 0; i < n; i++) distinctSet.add(nums[i]);

        int j = 0;
        int k = distinctSet.size();

        Map<Integer, Integer> currMap = new HashMap<>();

        for(int i = 0; i < n; i++){

            currMap.put(nums[i], currMap.getOrDefault(nums[i], 0) + 1);

            while(currMap.size() == k){
                count += n - i;
                currMap.put(nums[j], currMap.getOrDefault(nums[j], 0) - 1);
                if(currMap.get(nums[j]) == 0) currMap.remove(nums[j]);
                j++;

            }

        }

        return count;
    }
}
