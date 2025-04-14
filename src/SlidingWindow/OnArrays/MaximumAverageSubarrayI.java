package SlidingWindow.OnArrays;

public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(" Maximum Average Subarray: " + findMaxAverage(nums, k));
    }
    public static double findMaxAverage(int[] nums, int k) {
        int n= nums.length;
        int sum=0;
        double maxAvg= -Double.MAX_VALUE;
        int count=0;
        int j=0;

        for(int i=0; i<n; i++){
            sum += nums[i];

            if(i - j + 1 > k){
                sum -= nums[j];
                j++;
            }

            if(i - j + 1 == k){
                maxAvg = Math.max(maxAvg, sum/(double)k);
            }
        }

        return maxAvg;
    }
}
