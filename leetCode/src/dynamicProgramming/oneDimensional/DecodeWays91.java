package dynamicProgramming.oneDimensional;

public class DecodeWays91 {
    public int numDecodings(String s) {
        int n= s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i=1; i<= n; i++){
            if (s.charAt(i-1) != '0')
                dp[i] = dp[i-1];
            if (i > 1 && s.charAt(i-2) != '0' && Integer.valueOf(s.substring(i-2,i)) < 27)
                dp[i] += dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays91 prog = new DecodeWays91();
        System.out.println(prog.numDecodings("12"));
        System.out.println(prog.numDecodings("226"));
        System.out.println(prog.numDecodings("06"));
    }
}
