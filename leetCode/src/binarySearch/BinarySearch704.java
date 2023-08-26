package binarySearch;

public class BinarySearch704 {

    int[] nums;
    int target;
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return binarySearch(0, nums.length-1);
    }

    private int binarySearch(int left, int right){
        if (left > right)
            return -1;

        int mid = (right+ left) >> 1;

        if (nums[mid] == target)
            return mid;

        if (nums[mid]< target)
            left = mid+1;
        else
            right = mid-1;

        return binarySearch(left, right);

    }

    public static void main(String[] args) {
        BinarySearch704 prog = new BinarySearch704();
        System.out.println(prog.search(new int[]{-1,0,3,5,9,12}, 9));
    }

}
