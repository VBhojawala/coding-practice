package greedy;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves1509 {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n < 5) return 0;
        Arrays.sort(nums);
        long minDiff = Long.MAX_VALUE;
        for (int l=0, r=0; l<=3; l++){
            r= 3-l;
            minDiff = Math.min(minDiff, (long) nums[n-1-r] - nums[l]);
        }
        return (int)minDiff;
    }
}
