package DynamicProgramming.BuyAndSellStocks;

public class BuyAndSellStocksWithTransactionFee {
    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;

        System.out.println("Maximum Profit with unlimited transactions & given fee: " + maxProfitTopDown(prices, fee));
    }

    public static int maxProfitTopDown(int[] prices, int fee) {
        int n = prices.length;
        Integer[][] dp = new Integer[n][2];

        return helper(prices, n, 0, 1, dp, fee);
    }

    public static int helper(int[] prices, int n, int day, int buy, Integer[][] dp, int fee){

        if(day >= n){
            return 0;
        }

        if(dp[day][buy] != null) return dp[day][buy];

        if(buy == 1){

            int takeBuy = -prices[day] + helper(prices, n, day + 1, 0, dp, fee);
            int skipBuy = helper(prices, n, day + 1, 1, dp, fee);

            return dp[day][buy] = Math.max(takeBuy, skipBuy);
        }else{

            int takeSell = prices[day] - fee + helper(prices, n, day + 1, 1, dp, fee);
            int skipSell = helper(prices, n, day + 1, 0, dp, fee);

            return dp[day][buy] = Math.max(takeSell, skipSell);
        }
    }


}
