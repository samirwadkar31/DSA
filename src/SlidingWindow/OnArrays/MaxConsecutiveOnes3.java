package SlidingWindow.OnArrays;

public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {

        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println("Max Consecutive Ones in arr: " + longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int j = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeroCount++;
            }

            while(zeroCount > k){
                if(nums[j] == 0){
                    zeroCount--;
                }
                j++;
            }

            maxLength = Math.max(maxLength, i - j + 1);
        }

        return maxLength;
    }
}
