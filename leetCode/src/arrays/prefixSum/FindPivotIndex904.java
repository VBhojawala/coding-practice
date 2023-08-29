package arrays.prefixSum;

import java.util.Arrays;

public class FindPivotIndex904 {
    public int pivotIndex(int[] nums) {
        int leftSum=0, rightSum = Arrays.stream(nums).sum();

        for (int i=0;i<nums.length;i++){
            rightSum -= nums[i];

            if (leftSum == rightSum)
                return i;

            leftSum += nums[i];
        }
        return -1;
    }
}
