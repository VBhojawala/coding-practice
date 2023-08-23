package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning131 {

    String s;
    int n;
    List<List<String>> result;
    List<String> temp;

    boolean[][] dp;
    public List<List<String>> partition(String s) {
        this.s = s;
        n= s.length();
        result = new ArrayList<>();
        temp = new ArrayList<>();
        dp = new boolean[n][n];

        for (int i=0;i<n;i++)
            Arrays.fill(dp[i],true);

        for (int i=n-1;i>=0;i--){
            for (int j=i+1; j<n;j++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
            }
        }
        dfs(0);
        return  result;
    }

    private void dfs(int i){
        if (i == n){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int j=i;j<n;j++){
            if (dp[i][j]){
                temp.add(s.substring(i,j+1));
                dfs(j+1);
                temp.remove(temp.size() -1);
            }
        }
    }

    public static void main(String[] args) {
        PalindromePartitioning131 prog = new PalindromePartitioning131();
        System.out.println(prog.partition("aab"));
        System.out.println(prog.partition("a"));
    }
}
