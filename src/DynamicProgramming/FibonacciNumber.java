package DynamicProgramming;

public class FibonacciNumber {
    public static void main(String[] args) {
        int n=4;
        System.out.println(fib(n));
    }

    public static int fib(int n) {

        if(n<=1) return n;

        int a=0;
        int b=1;

        for(int i=2; i<=n; i++){
            int c= a+b;
            a=b;
            b=c;
        }

        return b;

        // int[] dp= new int[n+1];
        // dp[0]=0;
        // dp[1]=1;

        // for(int i=2; i<=n; i++){
        //     dp[i]=dp[i-1]+dp[i-2];
        // }

        // return dp[n];

        // int[] dp= new int[n+1];
        // Arrays.fill(dp, -1);

        // return helper(dp, n);
    }

    // public int helper(int[] dp, int n){

    //     if(n<=1) return n;

    //     if(dp[n]!=-1) return dp[n];

    //     dp[n]= fib(n-1)+fib(n-2);

    //     return dp[n];
    // }
}
