package arrays;

public class BestTimeToBuyStock121 {
    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        int profit;

        while (right < prices.length){
            if(prices[right] > prices[left] ){
                profit = prices[right] - prices[left];
                maxProfit = Math.max(profit, maxProfit);
            }else {
                left=right;
            }
            right++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println("Max profit : " + maxProfit(nums));

    }
}
