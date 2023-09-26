package arrays;

import java.util.Arrays;

public class WiggleSort280 {

    private int[] nums;
    private int temp;

    public void wiggleSort(int[] nums) {
        this.nums = nums;
        for (int i=1;i<nums.length;i++){
            if ((i%2 == 1 && nums[i] < nums[i-1]) || (i%2 == 0 && nums[i] > nums[i-1])){
                swap(i,i-1);
            }
        }

    }

    private void swap(int i, int j){
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        WiggleSort280 prog = new WiggleSort280();

        int[] nums = new int[] {3, 5, 2, 1, 6, 4};
        prog.wiggleSort(nums);

        Arrays.stream(nums).forEach(System.out::println);
    }
}
