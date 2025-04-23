package DynamicProgramming.knapsack;

public class PartitionSetInto2SubsetsWithMinimumAbsoluteSumDiff {
    public static void main(String[] args) {
        int arr[] = {1, 6, 11, 5};

        System.out.println(" Minimum absolute difference between two subsets is: " + minDifference(arr));
    }

    public static int minDifference(int arr[]) {
        // Your code goes here

        int n = arr.length;
        int sum = 0;

        for(int i = 0; i < n; i++) sum += arr[i];

        boolean[][] dp = new boolean[n][sum+1];
        for(int i = 0; i < n; i++) dp[i][0] = true;
        if(arr[0] <= sum) dp[0][arr[0]] = true;

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= sum; j++){

                boolean notTake= dp[i-1][j];

                boolean take = false;

                if(arr[i] <= j){
                    take = dp[i-1][j - arr[i]];
                }


                dp[i][j]= take || notTake;
            }
        }

        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i <= sum; i++){

            if(dp[n-1][i]){

                int s1 = i;
                int s2 = sum - i;

                minDiff = Math.min(minDiff, Math.abs(s1 - s2));

            }
        }
        return minDiff;
    }
}
