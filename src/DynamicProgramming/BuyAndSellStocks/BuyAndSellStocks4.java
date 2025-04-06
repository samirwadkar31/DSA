package DynamicProgramming.BuyAndSellStocks;

public class BuyAndSellStocks4 {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;

        System.out.println("Maximum Profit with at most k transactions: " + maxProfitTopDown(k, prices));
    }

    public static int maxProfitTopDown(int k, int[] prices) {
        int n = prices.length;
        Integer[][][] dp = new Integer[n][2][k + 1];

        return helper(prices, n, 0, 1, dp, k);
    }

    public static int helper(int[] prices, int n, int day, int buy, Integer[][][] dp, int transactionLimit){

        if(day >= n || transactionLimit == 0){
            return 0;
        }

        if(dp[day][buy][transactionLimit] != null) return dp[day][buy][transactionLimit];

        if(buy == 1){

            int takeBuy = -prices[day] + helper(prices, n, day + 1, 0, dp, transactionLimit);
            int skipBuy = helper(prices, n, day + 1, 1, dp, transactionLimit);

            return dp[day][buy][transactionLimit] = Math.max(takeBuy, skipBuy);
        }else{

            int takeSell = prices[day] + helper(prices, n, day + 1, 1, dp, transactionLimit - 1);
            int skipSell = helper(prices, n, day + 1, 0, dp, transactionLimit);

            return dp[day][buy][transactionLimit] = Math.max(takeSell, skipSell);
        }
    }
}
