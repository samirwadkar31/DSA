package DynamicProgramming.FibonacciType;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int n = nums.length-1;
        System.out.println("Max robbery: " + robRecursion(nums, n));
        System.out.println("Max robbery: " + robBottomUp(nums));
        System.out.println("Max robbery: " + robSpaceOptimization(nums));
    }

    public static int robRecursion(int[] nums, int i) {

        if(i<0) return 0;

        return Math.max(robRecursion(nums, i-2) +nums[i], robRecursion(nums, i-1));
    }

    public static int robBottomUp(int[] nums) {

        if(nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0], nums[1]);
        }
         int[] dp= new int[nums.length];

         dp[0]= nums[0];
         dp[1]= Math.max(nums[0], nums[1]);

         for(int i=2; i<nums.length; i++){
             dp[i]= Math.max(dp[i-2]+nums[i], dp[i-1]);
         }

         return dp[nums.length-1];
    }

    public static int robSpaceOptimization(int[] nums){
        int a= nums[0];
        int b= Math.max(nums[0], nums[1]);
        int maxLoot=0;
        for(int i=2; i<nums.length; i++){
            maxLoot= Math.max(a+nums[i], b);
            a=b;
            b=maxLoot;
        }
        return maxLoot;
    }
}
