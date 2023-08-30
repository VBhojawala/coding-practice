package twoPointers;

import java.util.Arrays;

public class MoveZeros283 {
    public void moveZeroes(int[] nums) {
        int left=0, right=0;

        while (right < nums.length){
            if (nums[right] == 0){
                right++;
                continue;
            }
            nums[left++] = nums[right++];
        }
        while (left < nums.length)
            nums[left++] = 0;
    }

    public static void main(String[] args) {
        MoveZeros283 prog = new MoveZeros283();
        int[] nums = {0,1,0,3,12};
        prog.moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
