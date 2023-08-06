package arrays;

public class JumpGameTwo45 {
    public static int jump(int[] nums) {
        int minJumps = 0;
        int curPos = 0;
        int prevMax =0;

        for(int i=0; i < nums.length-1; i++){
                curPos = Math.max(curPos, i+nums[i]);
                if(i == prevMax) {
                    minJumps++;
                    prevMax = curPos;
                }
        }
        return minJumps;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println("Minimum Number of jumps : "+ jump(nums));
    }
}
