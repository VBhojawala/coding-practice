package twoPointers;

import java.util.Arrays;

public class NextPermutation31 {

    private int[] nums;
    int n;
    public void nextPermutation(int[] nums) {
        this.nums = nums;
        n = nums.length;
        int i = n-2;

        while (i >=0 && nums[i+1] <= nums[i]){
            i--;
        }

        if (i >=0){
            int j = n-1;
            while (nums[j] <= nums[i]){
                j--;
            }
            swap(i,j);
        }
        reverse(i+1);
    }

    private void reverse(int start){
        int left = start, right= n-1;
        while (left<right){
            swap(left, right);
            left++; right--;
        }
    }

    private void swap(int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        NextPermutation31 prog = new NextPermutation31();
        int[] nums = new int[] {1,2,3};
        prog.nextPermutation(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

}
