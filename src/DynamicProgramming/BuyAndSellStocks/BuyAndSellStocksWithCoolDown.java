package DynamicProgramming.BuyAndSellStocks;

public class BuyAndSellStocksWithCoolDown {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};

        System.out.println("Maximum Profit with unlimited transactions and cooldown period of one day: " + maxProfitTopDown(prices));
    }

    public static int maxProfitTopDown(int[] prices) {

        int n = prices.length;
        Integer[][] dp = new Integer[n][2];

        return helper(prices, n, 0, 1, dp);
    }

    public static int helper(int[] prices, int n, int day, int buy, Integer[][] dp){

        if(day >= n){
            return 0;
        }

        if(dp[day][buy] != null) return dp[day][buy];

        if(buy == 1){

            int takeBuy = -prices[day] + helper(prices, n, day + 1, 0, dp);
            int skipBuy = helper(prices, n, day + 1, 1, dp);

            return dp[day][buy] = Math.max(takeBuy, skipBuy);
        }else{

            int takeSell = prices[day] + helper(prices, n, day + 2, 1, dp);
            int skipSell = helper(prices, n, day + 1, 0, dp);

            return dp[day][buy] = Math.max(takeSell, skipSell);
        }
    }
}
