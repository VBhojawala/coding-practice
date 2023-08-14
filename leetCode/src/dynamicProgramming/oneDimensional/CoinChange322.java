package dynamicProgramming.oneDimensional;

import java.util.Arrays;

public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        int[] noOfConins = new int[amount+1];
        Arrays.fill(noOfConins, amount +1);
        noOfConins[0] =0;

        for (int curAmount=1; curAmount<amount+1; curAmount++){
            for (int coin : coins){
                if(curAmount - coin >= 0){
                    noOfConins[curAmount] = Math.min(noOfConins[curAmount], noOfConins[curAmount-coin]+1);
                }
            }
        }
        return noOfConins[amount] == amount+1 ? -1 : noOfConins[amount];
    }

    public static void main(String[] args) {
        CoinChange322 prog = new CoinChange322();
        System.out.println(prog.coinChange(new int[]{1,2,5}, 11));
        System.out.println(prog.coinChange(new int[]{1,3,4,5}, 7));
    }
}
