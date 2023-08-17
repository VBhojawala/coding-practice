package dynamicProgramming.twoDimensional;

public class BestTimeToBuyAndSellStockIII123 {
    public int maxProfit(int[] prices) {
        int fb= -prices[0], fs=0, sb = -prices[0], ss= 0;
        for (int i=1;i<prices.length;i++){
            fb = Math.max(fb, -prices[i]);
            fs = Math.max(fs, fb + prices[i]);
            sb = Math.max(sb, fs - prices[i]);
            ss = Math.max(ss, sb + prices[i]);
        }
        return ss;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII123 prog = new BestTimeToBuyAndSellStockIII123();
        System.out.println(prog.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
}
