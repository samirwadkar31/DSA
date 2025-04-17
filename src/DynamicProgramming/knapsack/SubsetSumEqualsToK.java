package DynamicProgramming.knapsack;

public class SubsetSumEqualsToK {
    public static void main(String[] args) {

        int[] nums = {};
        int target = 10;

        int n = nums.length;
        Boolean[][] dp = new Boolean[n][target];

        System.out.println("Is subset sum equals to k exists: " + subsetSumTopDown(nums, dp, target, n - 1));

    }

    public static boolean subsetSumTopDown(int[] nums, Boolean[][] dp, int target, int i){

        if(target==0) return true;

        if(i<0 || target<0) return false;

        if(dp[i][target]!=null) return dp[i][target];

        boolean take= subsetSumTopDown(nums, dp, target-nums[i], i-1);
        boolean notTake= subsetSumTopDown(nums, dp, target, i-1);

        return dp[i][target]= take || notTake;
    }
}
