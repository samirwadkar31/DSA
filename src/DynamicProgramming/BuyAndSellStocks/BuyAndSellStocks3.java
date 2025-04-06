package DynamicProgramming.BuyAndSellStocks;

public class BuyAndSellStocks3 {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};

        System.out.println("Maximum Profit with at most 2 transactions: " + maxProfitTopDown(prices));
    }

    public static int maxProfitTopDown(int[] prices) {

        int n = prices.length;
        Integer[][][] dp = new Integer[n][2][3];

        return helper(prices, n, 0, 1, dp, 2);
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
