package twoPointers;

import java.util.Arrays;

public class SortColors75 {

    private int[] nums;
    private int temp;
    public void sortColors(int[] nums) {
        this.nums = nums;
        int left=0, right=nums.length-1, cur=0;

        while (cur <= right){
            if (nums[cur] == 0)
                swap(cur++, left++);
            else if (nums[cur] == 2)
                swap(cur, right--);
            else
                cur++;
        }
    }

    private void swap(int i, int j){
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors75 prog = new SortColors75();
        int[] nums = new int[]{2,0,2,1,2,0,0,1,2,1,1,0};
        prog.sortColors(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
