package dynamicProgramming.twoDimensional;

public class LongestRepeatingSubsequence1062 {
    public int longestRepeatingSubstring(String s) {
        int n = s.length(), l = 0;
        int[][] dp = new int[n][n];

        for (int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = i > 0 ? dp[i-1][j-1] + 1 : 1;
                    l = Math.max(l, dp[i][j]);
                }
            }
        }

        return l;
    }
}
