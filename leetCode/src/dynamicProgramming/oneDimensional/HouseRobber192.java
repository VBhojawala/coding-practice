package dynamicProgramming.oneDimensional;

public class HouseRobber192 {
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
        HouseRobber192 prog = new HouseRobber192();
        System.out.println(prog.rob(new int[]{1,2,3,1}));
    }
}
