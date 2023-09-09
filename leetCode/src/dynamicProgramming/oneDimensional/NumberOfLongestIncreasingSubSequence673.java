package dynamicProgramming.oneDimensional;

public class NumberOfLongestIncreasingSubSequence673 {
    public int findNumberOfLIS(int[] nums) {
        int maxLen=0, total=0, n= nums.length;
        int[] dp= new int[n];
        int[] count = new int[n];
        for (int i=0; i<n ; i++){
            dp[i] = 1; count[i] = 1;
            for (int j=0;j<i;j++){
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }else if (dp[j] +1 == dp[i]){
                        count[i] += count[j];
                    }
                }
            }
            if (dp[i] > maxLen){
                maxLen = dp[i];
                total = count[i];
            }else if (dp[i] == maxLen){
                total += count[i];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        NumberOfLongestIncreasingSubSequence673 prog = new NumberOfLongestIncreasingSubSequence673();
        System.out.println(prog.findNumberOfLIS(new int[]{1,3,5,4,7}));
        System.out.println(prog.findNumberOfLIS(new int[]{2,2,2,2,2}));
    }
}
