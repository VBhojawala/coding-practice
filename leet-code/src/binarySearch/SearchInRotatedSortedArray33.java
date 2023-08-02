package binarySearch;

public class SearchInRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        int left =0, right = nums.length -1, mid =0;

        while (left < right){

            mid = left + ( (right - left) / 2 ) ;

            if(nums[left] <= nums[mid]){
                if(nums[left] <= target &&  target <= nums[mid])
                    right = mid;
                else
                    left = mid +1;
            }else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

        }
        return nums[left] == target ? left : -1;
    }
}
