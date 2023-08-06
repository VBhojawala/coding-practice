package slidingWindow;

public class MinimumSizeSubArraySum209 {

    public static int minSubArrayLen(int target, int[] nums) {
        int l=0, r=0 ;
        int curSum = nums[0];
        int minWindow = Integer.MAX_VALUE;

        while (l < nums.length && r < nums.length){
            if(curSum >= target){
                minWindow = Math.min(minWindow, r - l + 1);
                curSum -= nums[l];
                l++;

            }else if(r < nums.length -1 ) {
                r++;
                curSum+= nums[r];
            }else {
                curSum-=nums[l];
                l++;
            }
        }
        return minWindow == Integer.MAX_VALUE ? 0 : minWindow;

    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        System.out.println("Window size : " + minSubArrayLen(111, nums));
    }
}
