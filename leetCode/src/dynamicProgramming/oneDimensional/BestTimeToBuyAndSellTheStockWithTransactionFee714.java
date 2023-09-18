package dynamicProgramming.oneDimensional;

public class BestTimeToBuyAndSellTheStockWithTransactionFee714 {
    public int maxProfit(int[] prices, int fee) {
        int s1 = -prices[0], s2 = 0;
        for (int i=1; i< prices.length; i++){
            s1 = Math.max(s1, s2 - prices[i]);
            s2 = Math.max(s2, s1 + prices[i] - fee);
        }
        return s2;
    }
}
