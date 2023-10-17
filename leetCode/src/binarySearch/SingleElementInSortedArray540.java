package binarySearch;

public class SingleElementInSortedArray540 {
    public int singleNonDuplicate(int[] nums) {
        int left =0, right= nums.length -1, mid;
        while (left < right){
            mid = left + (right- left) / 2;
            if (mid % 2 == 1) mid--;

            if (nums[mid] == nums[mid+1])
                left = mid +2;
            else
                right = mid;
        }
        return nums[left];
    }
}
