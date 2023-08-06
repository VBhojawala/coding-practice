package binarySearch;

public class FindFirstAndLastPositionOfElementInSortedArray34 {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target);
        int right = binarySearch(nums, target+1);

        return left == right ? new int[]{-1,-1} : new int[]{left, right-1};
    }

    private int binarySearch(int[] nums, int target){
        int left =0 , right = nums.length, mid = 0;
        while (left < right){
            mid = left + ((right - left) / 2);

            if (nums[mid] >= target)
                right = mid;
            else
                left = mid +1;
        }
        return left;
    }
}
