package dynamicProgramming.oneDimensional;

public class CheckIfThereIsAValidPartitionInArray2369 {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n+1];
        dp[0]= true;
        for (int i=2; i<=n;i++){
            if (nums[i-1] == nums[i-2])
                dp[i] = dp[i] || dp[i-2];
            if (i>2 && nums[i-1] == nums[i-2] && nums[i-2] == nums[i-3])
                dp[i] = dp[i] || dp[i-3];
            if (i>2 && nums[i-1] == (nums[i-2] + 1) && nums[i-2] == (nums[i-3] + 1))
                dp[i] = dp[i] || dp[i-3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        CheckIfThereIsAValidPartitionInArray2369 prog = new CheckIfThereIsAValidPartitionInArray2369();
        System.out.println(prog.validPartition(new int[]{4,4,4,5,6}));
        System.out.println(prog.validPartition(new int[]{1,1,1,2}));
    }
}
