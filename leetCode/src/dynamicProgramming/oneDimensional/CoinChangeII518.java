package dynamicProgramming.oneDimensional;

public class CoinChangeII518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] count = new int[amount+1];
        count[0] = 1;
        for (int coinI = 0; coinI < n; coinI++){
            for (int countI = coins[coinI]; countI <= amount; countI++){
                count[countI] += count[countI - coins[coinI]];
            }
        }
        return count[amount];
    }
}
