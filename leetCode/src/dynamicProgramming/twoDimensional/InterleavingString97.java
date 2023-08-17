package dynamicProgramming.twoDimensional;

public class InterleavingString97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        int m= s1.length(), n= s2.length();

        if((m+n) != s3.length())
            return false;

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        int k;
        for (int i=0; i<=m;i++) {
            for (int j = 0; j <= n; j++) {
                k = i + j - 1;
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(k)) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(k)) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        InterleavingString97 prog = new InterleavingString97();
        System.out.println(prog.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(prog.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(prog.isInterleave("", "", ""));
    }
}
