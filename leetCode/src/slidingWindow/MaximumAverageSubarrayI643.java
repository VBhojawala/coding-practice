package slidingWindow;

public class MaximumAverageSubarrayI643 {
    public double findMaxAverage(int[] nums, int k) {
        int windowSum =0, max;
        for (int i=0;i<k;i++)
            windowSum+= nums[i];

        max = windowSum;

        for (int i=k; i< nums.length;i++){
            windowSum += (nums[i] - nums[i-k]);
            max = Math.max(max, windowSum);
        }

        return max * 1.0 / k;
    }
}
