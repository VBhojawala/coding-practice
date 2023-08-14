package dynamicProgramming.oneDimensional;

public class ClimbingStairs70 {

    public int climbStairs(int n) {
        int prev1=1, prev2=1, temp;

        for (int i=0;i<n-1; i++){
            temp = prev1;
            prev1 += prev2;
            prev2= temp;
        }

        return prev1;
    }

    public static void main(String[] args) {
        ClimbingStairs70 prog = new ClimbingStairs70();
        System.out.println(prog.climbStairs(5));
    }
}
