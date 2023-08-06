package binarySearch;

public class SearchInsertPosition35 {
    public static int searchInsert(int[] nums, int target) {
        int left =0, right = nums.length;

        while (left < right){
            int mid = left + (right-left) / 2 ;
            if(nums[mid] >= target)
                right = mid;
            else
                left = mid +1;
        }
        return left;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 5));
    }
}
