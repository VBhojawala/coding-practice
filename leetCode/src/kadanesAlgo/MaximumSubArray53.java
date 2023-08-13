package kadanesAlgo;

public class MaximumSubArray53 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curSum = 0;

        for (int i=0; i< nums.length;i++){
            if (curSum < 0)
                curSum = 0;
            curSum += nums[i];
            max = Math.max(max, curSum);
        }

        return max;
    }
}
