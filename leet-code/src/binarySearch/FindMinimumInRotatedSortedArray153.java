package binarySearch;

public class FindMinimumInRotatedSortedArray153 {

    public static int findMin(int[] nums) {
        if(nums[0] <= nums[nums.length-1])
            return nums[0];

        int left =0, right= nums.length, mid =0;

        while (left < right){
            mid = left + ( (right -left) / 2);

            if (nums[0] <= nums[mid]){
                left = mid + 1;
            }else {
                right = mid;
            }

        }
        return  nums[left];
    }

    public static void main(String[] args) {
//        int[] nums = {3,4,5,1,2};
//        System.out.println(findMin(nums));

        int[] nums = {2,3,4,5,1};
        System.out.println(findMin(nums));
    }

}
