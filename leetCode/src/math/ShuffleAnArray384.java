package math;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray384 {
    private int[] nums;
    private int[] original;
    private Random random;
    public ShuffleAnArray384(int[] nums) {
        this.nums = nums;
        original = Arrays.copyOf(nums, nums.length);
        random = new Random();
    }

    public int[] reset() {
        nums = Arrays.copyOf(original, original.length);
        return nums;
    }

    public int[] shuffle() {
        for (int i=0; i<nums.length; i++){
            swap(i, i+ random.nextInt(nums.length -i));
        }
        return nums;
    }

    private void swap(int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
