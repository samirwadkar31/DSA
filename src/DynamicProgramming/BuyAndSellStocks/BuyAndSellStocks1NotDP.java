package DynamicProgramming.BuyAndSellStocks;

public class BuyAndSellStocks1NotDP {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        System.out.println("Maximum Profit with only one buy & sell transaction is: " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n= prices.length;
        int min= Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<n; i++){
            if(prices[i]<min){
                min= prices[i];
            }
            int profit= prices[i]-min;
            maxProfit= Math.max(profit, maxProfit);

        }
        return maxProfit;

    }
}
