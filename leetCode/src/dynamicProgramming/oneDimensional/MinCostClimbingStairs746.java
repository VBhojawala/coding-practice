package dynamicProgramming.oneDimensional;

public class MinCostClimbingStairs746 {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        for (int i= n-3; i>=0;i--){
            cost[i] += Math.min(cost[i+1], cost[i+2]);
        }
        return Math.min(cost[0], cost[1]);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs746 prog = new MinCostClimbingStairs746();
        System.out.println(prog.minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println(prog.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
