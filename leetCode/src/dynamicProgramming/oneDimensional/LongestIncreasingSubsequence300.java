package dynamicProgramming.oneDimensional;

import java.util.Arrays;

public class LongestIncreasingSubsequence300 {
    public int lengthOfLIS(int[] nums) {
        int lis[] = new int[nums.length];
        Arrays.fill(lis, 1);
        int max = 1;

        for (int i=nums.length-1; i>=0 ;i--){
            for (int j=i+1; j< nums.length;j++){
                if (nums[i] < nums[j] ){
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
            max = Math.max(max, lis[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence300 prog = new LongestIncreasingSubsequence300();
        System.out.println(prog.lengthOfLIS(new int[]{0,3,1,6,2,2,7}));
    }

}
