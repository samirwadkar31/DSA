package SlidingWindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {

        int n= nums.length;
        int sum=0;
        int minsize=Integer.MAX_VALUE;
        int j=0;

        for(int i=0; i<n; i++){
            sum=sum+nums[i];
            while(sum>=target){
                minsize= Math.min(i-j+1, minsize);
                sum=sum-nums[j];
                j++;
            }
        }

        if(minsize==Integer.MAX_VALUE){
            return 0;
        }
        return minsize;
    }
}
