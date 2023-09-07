package dynamicProgramming.oneDimensional;

public class HouseRobberII213 {

    private int[] nums;
    public int rob(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        if (n==1) return nums[0];
        return Math.max(houseRob(0, n-1), houseRob(1,n));
    }

    private int houseRob(int start, int end){
        int prev1=0, prev2=0, temp;

        for (int i=start; i< end; i++){
            temp = Math.max(prev2+nums[i], prev1);
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }

    public static void main(String[] args) {
        HouseRobberII213 prog = new HouseRobberII213();
        System.out.println(prog.rob(new int[] {1,2,3}));
        System.out.println(prog.rob(new int[] {1,2,3,1}));
        System.out.println(prog.rob(new int[] {1,2,3}));
    }
}
