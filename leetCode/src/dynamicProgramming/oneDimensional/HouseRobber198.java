package dynamicProgramming.oneDimensional;

public class HouseRobber198 {
    public int rob(int[] nums) {

        int prev2 = 0,prev1 = nums[0], temp;

        for (int i=1;i<nums.length;i++){
            temp = prev1;
            prev1 = Math.max(prev2+nums[i], prev1);
            prev2 = temp;
        }

        return prev1;
    }

    public static void main(String[] args) {
        HouseRobber198 prog = new HouseRobber198();
        System.out.println(prog.rob(new int[]{1,2,3,1}));
    }
}
