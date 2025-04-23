package DynamicProgramming.knapsack;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums= {1,5,11,5};
        System.out.println(canPartitionTopDown(nums));
        System.out.println(canPartitionBottomUp(nums));
    }

    public static boolean canPartitionTopDown(int[] nums) {
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }

        if(sum%2!=0) return false;

        int target= sum/2;

        Boolean[][] dp= new Boolean[nums.length][target+1]; //Capital Boolean because we want null when initializing dp for the first time. with boolean, its False by default. we want both False & True to be stored in dp hence using Boolean with null

        return subsetSum(nums, dp, target, nums.length-1);
    }

    public static boolean subsetSum(int[] nums, Boolean[][] dp, int target, int i){

        if(target==0) return true;

        if(i == 0) return nums[0] == target;

        if(dp[i][target] != null) return dp[i][target];

        boolean notTake= subsetSum(nums, dp, target, i-1);

        boolean take = false;

        if(nums[i] <= target){
            take= subsetSum(nums, dp, target-nums[i], i-1);
        }


        return dp[i][target]= take || notTake;
    }

    public static boolean canPartitionBottomUp(int[] nums){
        int n = nums.length;
        int sum=0;
        for(int i=0; i<n; i++){
            sum+=nums[i];
        }

        if(sum%2!=0) return false;

        int target= sum/2;

        boolean[][] dp= new boolean[n][target+1];
        for(int i = 0; i < n; i++) dp[i][0] = true;
        if(nums[0] <= target) dp[0][nums[0]] = true;

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= target; j++){

                boolean notTake= dp[i-1][j];

                boolean take = false;

                if(nums[i] <= j){
                    take = dp[i-1][j - nums[i]];
                }


                dp[i][j]= take || notTake;
            }
        }
        return dp[n-1][target];
    }
}
