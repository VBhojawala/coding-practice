package twoPointers;

import java.util.Arrays;

public class MaxNumberOfKSumPairs1679 {
    public int maxOperations(int[] nums, int k) {
        int left =0, right= nums.length-1, sum=0, count=0;
        Arrays.sort(nums);
        while (left < right){
            sum = nums[left] + nums[right];
            if (sum<k)
                left++;
            else if (sum> k)
                right--;
            else{
                left++;right--;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaxNumberOfKSumPairs1679 prog = new MaxNumberOfKSumPairs1679();
        System.out.println(prog.maxOperations(new int[]{1,2,3,4}, 5));
        System.out.println(prog.maxOperations(new int[]{3,1,3,4,3}, 6));
    }
}
