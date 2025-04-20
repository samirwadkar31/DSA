package DynamicProgramming.knapsack;

import java.util.Arrays;

public class TargetSumAKApartitionsWithGivenDifference {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;

        System.out.println("Count of subsets with given Target Sum: " + findTargetSumWaysTopDown(nums, target));
        System.out.println("Count of subsets with given Target Sum: " + findTargetSumWaysBottomUp(nums, target));
    }

    public static int findTargetSumWaysTopDown(int[] nums, int target) {

        int n = nums.length;

        int sum = 0;

        for(int i = 0; i < n; i++) sum += nums[i];

        // s1 + s2 = sum       --1
        // s1 - s2 = target    --2
        // sum - s2 - s2 = target    -- from eqn 1
        // (sum + target)/2 = s2
        // we need to find the count of subset sum s2 in nums

        int newtarget = (sum + target)/2;

        if((sum + target)% 2 != 0 || target > sum || (sum + target) < 0) return 0;

        int[][] dp = new int[n][newtarget + 1];
        for(int[] arr: dp) Arrays.fill(arr, -1);

        return helper(nums, newtarget, n-1, dp);
    }


    public static int helper(int[] nums, int target, int i, int[][] dp){

        if(i == 0){
            if(target == 0 && nums[0] == 0) return 2;
            if(target == 0 || nums[0] == target) return 1;
            return 0;
        }

        if(dp[i][target] != -1) return dp[i][target];

        int skip = helper(nums, target, i - 1, dp);

        int take = 0;

        if(nums[i] <= target){
            take = helper(nums, target - nums[i], i - 1, dp);
        }


        return dp[i][target] = skip + take;
    }

    public static int findTargetSumWaysBottomUp(int[] nums, int target) {

        int n = nums.length;

        int sum = 0;

        for(int i = 0; i < n; i++) sum += nums[i];

        int newTarget = (sum + target)/2;

        if((sum + target)% 2 != 0 || target > sum || (sum + target) < 0) return 0;

        int[][] dp = new int[n][newTarget+1];

        for(int i = 0; i < n; i++) dp[i][0] = 1;

        if(nums[0] == 0) dp[0][0] = 2;
        else if (nums[0] <= newTarget) dp[0][nums[0]] = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= newTarget; j++){

                int skip = dp[i - 1][j];

                int take = 0;

                if(nums[i] <= j){
                    take = dp[i - 1][j - nums[i]];
                }

                dp[i][j] = skip + take;
            }
        }

        return dp[n - 1][newTarget];
    }
}
