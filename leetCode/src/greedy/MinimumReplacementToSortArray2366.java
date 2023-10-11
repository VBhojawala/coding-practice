package greedy;

public class MinimumReplacementToSortArray2366 {
    public long minimumReplacement(int[] nums) {
        long count = 0, requiredBreak=0;
        int n = nums.length;

        for (int i= n-2;  i>=0; i--){
            if (nums[i] <= nums[i+1]) continue;;
            requiredBreak = (long) (nums[i] + nums[i+1] - 1) / (long) nums[i+1];
            count += requiredBreak -1;
            nums[i] = nums[i] / (int) requiredBreak;
        }
        return count;
    }
}
