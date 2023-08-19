package bitManipulation;

import java.util.Arrays;

public class CountingBits338 {
    public int[] countBits(int n) {
        int dp[]= new int[n+1];
        int pow =1;

        for (int i=1; i<n+1;i++){
            if (pow * 2 == i)
                pow = i;
            dp[i] = dp[i-pow] +1;
        }
        return dp;
    }

    public static void main(String[] args) {
        CountingBits338 prog = new CountingBits338();
        Arrays.stream(prog.countBits(5)).forEach(System.out::println);
    }
}
