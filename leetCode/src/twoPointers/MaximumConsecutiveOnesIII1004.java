package twoPointers;

public class MaximumConsecutiveOnesIII1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right =0;
        while (right < nums.length){
            if (nums[right++] == 0)
                k--;
            if (k < 0 && nums[left++] == 0)
                k++;
        }
        return right-left;
    }
}
