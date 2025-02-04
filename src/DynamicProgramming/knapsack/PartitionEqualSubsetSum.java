package DynamicProgramming.knapsack;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums= {1,5,11,5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
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

        if(i<0 || target<0) return false;

        if(dp[i][target]!=null) return dp[i][target];

        boolean take= subsetSum(nums, dp, target-nums[i], i-1);
        boolean notTake= subsetSum(nums, dp, target, i-1);

        return dp[i][target]= take || notTake;
    }
}
