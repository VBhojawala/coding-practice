package kadanesAlgo;

public class MaximumSumCircularSubArray918 {
    public int maxSubarraySumCircular(int[] nums) {
        int minSum = nums[0], maxSum=nums[0];
        int curMin = nums[0], curMax = nums[0];
        int total = nums[0];

        for (int i=1; i< nums.length; i++){
            curMin = Math.min(nums[i], curMin + nums[i]);
            curMax = Math.max(nums[i], curMax + nums[i]);
            total += nums[i];
            minSum = Math.min(minSum, curMin);
            maxSum = Math.max(maxSum, curMax);
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
