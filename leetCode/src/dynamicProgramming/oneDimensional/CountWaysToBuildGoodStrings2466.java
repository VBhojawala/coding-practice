package dynamicProgramming.oneDimensional;

public class CountWaysToBuildGoodStrings2466 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int mod = (int) 1e9+7 ;

        for (int i=1; i <= high; i++){
            if (i >= zero)
                dp[i] += dp[i-zero];
            if (i >= one)
                dp[i] += dp[i-one];
            dp[i] %= mod;
        }

        int count =0;
        for (int i=low; i<=high;i++){
            count += dp[i];
            count %= mod;
        }

        return count;
    }
}
