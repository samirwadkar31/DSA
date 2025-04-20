package DynamicProgramming.knapsack;

public class SubsetSumEqualsToK {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 3};
        int target = 6;

        int n = nums.length;
        Boolean[][] dp = new Boolean[n][target + 1];

        System.out.println("Is subset sum equals to k exists: " + subsetSumTopDown(nums, dp, target, n - 1));
        System.out.println("Is subset sum equals to k exists: " + subsetSumBottomUp(nums, target));
    }

    public static boolean subsetSumTopDown(int[] nums, Boolean[][] dp, int target, int i){

        if(target==0) return true;

        if(i == 0) return nums[0] == target;

        if(dp[i][target] != null) return dp[i][target];

        boolean notTake= subsetSumTopDown(nums, dp, target, i-1);

        boolean take = false;

        if(nums[i] <= target){
            take= subsetSumTopDown(nums, dp, target-nums[i], i-1);
        }


        return dp[i][target]= take || notTake;
    }

    public static boolean subsetSumBottomUp(int[] nums, int target){

        int n = nums.length;

        boolean[][] dp = new boolean[n][target+1];
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
