package arrays;

public class JumpGame55 {

    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int i=0;i<nums.length;i++){
            if( maxReach < i ){
                return false;
            }else {
                maxReach = Math.max(maxReach, i+nums[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println("Can Jump ? : " + canJump(nums));

    }
}
