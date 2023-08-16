package dynamicProgramming.twoDimensional;

import java.util.Arrays;

public class LongestPalindromicSubstring5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        Arrays.stream(dp).forEach(r-> Arrays.fill(r, true));

        int start=0, max=1;

        for (int i= n-2; i>=0; i--){
            for (int j=i+1; j<n;j++){
                dp[i][j] = false;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j] && max < j - i + 1) {
                        max = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring5 prog = new LongestPalindromicSubstring5();
        System.out.println(prog.longestPalindrome("babad"));
    }
}
