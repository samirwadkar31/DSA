package DynamicProgramming.FibonacciType;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairsRecursion(n));
        System.out.println(climbStairsBottomUp(n));
    }

    public static int climbStairsRecursion(int n){

        if(n <= 1) return 1;

        return climbStairsRecursion(n-1) + climbStairsRecursion(n-2);
    }

    public static int climbStairsBottomUp(int n) {

        if(n==1) return 1;

        int[] dp = new int[n+1];

        dp[1]=1;
        dp[2]=2;

        for(int i=3; i<=n; i++){
            dp[i]= dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}
