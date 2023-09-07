package dynamicProgramming.twoDimensional;

import java.util.ArrayList;
import java.util.List;

public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i=triangle.size() -1; i>=0;i--){
            for (int j=0; j<=i; j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Triangle120 prog = new Triangle120();
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> level1 = new ArrayList<>();
        level1.add(2);
        List<Integer> level2 = new ArrayList<>();
        level2.add(3); level2.add(4);
        List<Integer> level3 = new ArrayList<>();
        level3.add(6); level3.add(5); level3.add(7);
        List<Integer> level4 = new ArrayList<>();
        level4.add(4); level4.add(1); level4.add(8); level4.add(3);
        triangle.add(level1); triangle.add(level2);
        triangle.add(level3); triangle.add(level4);

        System.out.println(prog.minimumTotal(triangle));


    }
}
