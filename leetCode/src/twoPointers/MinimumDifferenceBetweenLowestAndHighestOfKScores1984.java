package twoPointers;

import java.util.Arrays;

public class MinimumDifferenceBetweenLowestAndHighestOfKScores1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int left =0, right=k-1, min = Integer.MAX_VALUE;
        for (;right<nums.length;left++,right++)
            min = Math.min(min, nums[right]-nums[left]);
        return min;
    }
}
