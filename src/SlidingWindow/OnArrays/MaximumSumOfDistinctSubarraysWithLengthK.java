package SlidingWindow.OnArrays;

import java.util.HashSet;
import java.util.Set;

public class MaximumSumOfDistinctSubarraysWithLengthK {

    public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9};
        int k = 3;

        System.out.println("Maximum Sum of Distinct Subarrays With Length K: " + maximumSubarraySum(nums, k));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int j = 0;
        long sum = 0;
        long max_sum = 0;
        Set<Integer> set = new HashSet<>();

        // 1 1 1 5 4 4 2 9 9 9
        for(int i=0; i<n; i++){

            sum += nums[i];

            while(set.contains(nums[i])){
                set.remove(nums[j]);
                sum -= nums[j];
                j++;
                continue;
            }

            if(i - j + 1 > k){
                set.remove(nums[j]);
                sum -= nums[j];
                j++;
            }

            set.add(nums[i]);

            if(i - j + 1 == k){
                max_sum = Math.max(max_sum, sum);
            }
        }
        return max_sum;
    }
}
