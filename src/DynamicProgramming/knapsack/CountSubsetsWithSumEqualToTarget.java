package DynamicProgramming.knapsack;

import java.util.Arrays;

public class CountSubsetsWithSumEqualToTarget {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3};
        int target = 6;
        System.out.println(" Subsets count with sum equals to target: " + perfectSumTopDown(nums, target));
        System.out.println(" Subsets count with sum equals to target: " + perfectSumBottomUp(nums, target));
    }

    public static int perfectSumTopDown(int[] nums, int target) {
        // code here
        int n = nums.length;
        int[][] dp = new int[n][target+1];

        for(int[] arr: dp) Arrays.fill(arr, -1);

        return helper(nums, target, n - 1, dp);
    }

    public static int helper(int[] nums, int target, int i, int[][] dp){
        
        if(i == 0){
            if (target == 0 && nums[0] == 0) return 2;
            if(target == 0 || nums[0] == target) return 1;
            return 0;
        }
        
        if(dp[i][target] != -1) return dp[i][target];

        int skip = helper(nums, target, i - 1, dp);

        int pick = 0;

        if(nums[i] <= target){
            pick = helper(nums, target - nums[i], i - 1, dp);
        }


        return dp[i][target] = skip + pick;
    }

    public static int perfectSumBottomUp(int[] nums, int target) {

        int n = nums.length;

        int[][] dp = new int[n][target+1];

        for(int i = 0; i < n; i++) dp[i][0] = 1;

        if(nums[0] == 0) dp[0][0] = 2;
        else if (nums[0] <= target) dp[0][nums[0]] = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= target; j++){

                int skip = dp[i - 1][j];

                int take = 0;

                if(nums[i] <= j){
                    take = dp[i - 1][j - nums[i]];
                }

                dp[i][j] = skip + take;
            }
        }

        return dp[n - 1][target];
    }
}
