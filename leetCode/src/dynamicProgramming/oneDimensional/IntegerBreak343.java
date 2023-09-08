package dynamicProgramming.oneDimensional;

public class IntegerBreak343 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        for (int i=2;i<=n;i++){
            for (int j=1;j<i;j++){
                dp[i] = Math.max(dp[i], Math.max(dp[i-j]*j, (i-j)*j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        IntegerBreak343 prog = new IntegerBreak343();
        System.out.println(prog.integerBreak(5));
        System.out.println(prog.integerBreak(10));
    }
}
