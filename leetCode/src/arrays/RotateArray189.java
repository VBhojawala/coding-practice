package arrays;

public class RotateArray189 {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0,nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k,nums.length-1);
    }

    public static void reverse(int[] nums , int i, int j){
        int tmp;
        for (;i<j;i++,j--){
            tmp = nums [i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        for (int i=0;i < nums.length;i++){
            System.out.print(nums[i] +", ");
        }
    }
}
