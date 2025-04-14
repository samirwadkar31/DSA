package DynamicProgramming;

import java.util.Arrays;

public class MinimumCostForTickets {

    public static void main(String[] args) {
        int[] days ={1,4,6,7,8,20};
        int[] costs ={2,7,15};
        //output: 11

        System.out.println(" Minimum Cost For Tickets: " + mincostTickets(days,costs));

    }

    public static int mincostTickets(int[] days, int[] costs) {

        int n = days.length;

        int[] dp = new int[days[n-1]];
        Arrays.fill(dp, -1);

        return helper(days, costs, 0, n, dp);
    }

    public static int helper(int[] days, int[] costs, int i, int n, int[] dp){

        if(i >= n) return 0;

        if(dp[i] != -1) return dp[i];

        int cost1 = costs[0] + helper(days, costs, i + 1, n, dp);

        int j = i;
        int maxLimit = days[j] + 7;
        while(j < n && days[j] < maxLimit){
            j++;
        }
        int cost7 = costs[1] + helper(days, costs, j, n, dp);

        j = i;
        maxLimit = days[j] + 30;
        while(j < n && days[j] < maxLimit){
            j++;
        }
        int cost30 = costs[2] + helper(days, costs, j, n, dp);

        return dp[i] = Math.min(cost1, Math.min(cost7, cost30));
    }
}
