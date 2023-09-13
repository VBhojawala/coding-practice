package slidingWindow;

public class LongestSubarrayOf1sAfterDeletingOneElement1493 {
    public int longestSubarray(int[] nums) {
        int zeroCount=0, max =0;
        int left=0;
        for (int right=0;right<nums.length;right++){
            if (nums[right] == 0)
                zeroCount++;
            while (zeroCount > 1){
                if (nums[left++] == 0)
                    zeroCount--;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubarrayOf1sAfterDeletingOneElement1493 prog = new LongestSubarrayOf1sAfterDeletingOneElement1493();
        System.out.println(prog.longestSubarray(new int[]{1,1,0,1}));
        System.out.println(prog.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println(prog.longestSubarray(new int[]{1,1,1}));
    }
}
