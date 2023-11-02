package arrays;

import java.util.Arrays;

public class ThreeSumClosest16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, minDiff = Integer.MAX_VALUE;

        for (int i=0; i<n; i++){
            int l= i+1, r= n-1;
            while (l < r){
                int curSum = nums[i] + nums[l] + nums[r];
                if (curSum == target) return target;
                if (Math.abs(target - curSum) < Math.abs(target - minDiff))
                    minDiff = curSum;
                if (curSum > target)
                    r--;
                else
                    l++;
            }
        }

        return minDiff;
    }
}
