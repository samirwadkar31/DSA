package SlidingWindow.OnArrays;

public class LongestNiceSubarrayBitManipulation {
    public static void main(String[] args) {

        int[] nums = {1,3,8,48,10};
        System.out.println("Length of longest nice subarray is: " + longestNiceSubarray(nums));
    }

    public static int longestNiceSubarray(int[] nums) {

        int n= nums.length;
        int niceSubarrays=0;

        int j = 0;
        int num = 0;

        for(int i=0; i<n; i++){

            while((num & nums[i]) !=0){
                num = num^nums[j];
                j++;
            }

            num = num | nums[i];
            niceSubarrays = Math.max(niceSubarrays, i - j + 1);
        }

        return niceSubarrays;
    }
}

