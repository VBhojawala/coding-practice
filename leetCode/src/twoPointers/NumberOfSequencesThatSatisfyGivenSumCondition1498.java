package twoPointers;

import java.util.Arrays;

public class NumberOfSequencesThatSatisfyGivenSumCondition1498 {
    final static int MOD = (int) 1e9+7;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, n = nums.length, right = n-1;
        int count=0;
        int[] power = new int[n+1];
        power[0] =1 ;
        for (int i=1;i< power.length;i++)
            power[i] = (power[i-1]*2) % MOD;
        while (left <= right){
            if (nums[left] + nums[right] > target)
                right--;
            else {
                count = ( count  + power[right-left] ) % MOD;
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfSequencesThatSatisfyGivenSumCondition1498 prog = new NumberOfSequencesThatSatisfyGivenSumCondition1498();
        System.out.println(prog.numSubseq(new int[]{3,5,6,7}, 9));
        System.out.println(prog.numSubseq(new int[]{3,3,6,8}, 10));
        System.out.println(prog.numSubseq(new int[]{14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13
                ,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14}, 22));
    }
}
