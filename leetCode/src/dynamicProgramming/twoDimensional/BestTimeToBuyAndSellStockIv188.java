package dynamicProgramming.twoDimensional;

public class BestTimeToBuyAndSellStockIv188 {
    public int maxProfit(int k, int[] prices) {
        int n= prices.length;
        if(n <= 1)
            return 0;
        int dp[][][] = new int[n][k+1][2];

        for (int i=0; i <= k; i++)
            dp[0][i][1] = -prices[0];

        for (int i=1; i<n;i++){
            for (int j=1;j<=k;j++){
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[n-1][k][0];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIv188 prog = new BestTimeToBuyAndSellStockIv188();
        System.out.println(prog.maxProfit(2, new int[]{3,2,6,5,0,3}));
    }
}
