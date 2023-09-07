package dynamicProgramming.oneDimensional;

import java.util.Arrays;

public class PartitionEqualsSubsetSum416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        sum /= 2;

        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int num : nums){
            for (int i = sum; i >= num; i--){
                dp[i] |= dp[i-num];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        PartitionEqualsSubsetSum416 prog = new PartitionEqualsSubsetSum416();
        System.out.println(prog.canPartition(new int[]{1,5,11,5}));
        System.out.println(prog.canPartition(new int[]{1,2,3,5}));
    }
}
