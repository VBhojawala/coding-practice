package arrays;

public class MonotonicArray896 {
    public boolean isMonotonic(int[] nums) {
        boolean isIncreasing = false, isDecreasing = false;

        for (int i=1; i< nums.length; i++){
            if (nums[i] < nums[i-1])
                isDecreasing = true;
            else if (nums[i] > nums[i-1])
                isIncreasing = true;

            if (isDecreasing && isIncreasing)
                return false;
        }
        return true;
    }
}
