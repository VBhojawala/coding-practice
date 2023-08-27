package twoPointers;

import java.util.Arrays;

public class SquaresOfSortedArray997 {
    public int[] sortedSquares(int[] nums) {
        int left =0, right =nums.length -1, cur = right;
        int[] result = new int[nums.length];

        while (left <= right){
            if (Math.abs(nums[left]) > Math.abs(nums[right]))
                result[cur--] = nums[left] * nums[left++];
            else
                result[cur--] = nums[right] * nums[right--];
        }
        return result;
    }

    public static void main(String[] args) {
        SquaresOfSortedArray997 prog = new SquaresOfSortedArray997();
        Arrays.stream(prog.sortedSquares(new int[]{-4,-1,0,3,10})).forEach(System.out::println);
        Arrays.stream(prog.sortedSquares(new int[]{-7,-3,2,3,11})).forEach(System.out::println);
    }
}
