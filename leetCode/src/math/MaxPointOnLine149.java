package math;

import java.util.HashMap;
import java.util.Map;

public class MaxPointOnLine149 {
    public int maxPoints(int[][] points) {
        int max = 1;
        Map<String, Integer> countMap = new HashMap<>();
        int x1, y1, x2, y2, dx, dy, g;
        for (int i=0; i< points.length; i++){
            countMap.clear();
            x1 = points[i][0]; y1= points[i][1];
            for ( int j= i+1; j< points.length; j++){
               x2 = points[j][0]; y2 = points[j][1];
               dx = x2 - x1 ; dy = y2 -y1;
               g = gcd(dx, dy);
               String key = (dx/g) + "-"+(dy/g);
               countMap.put(key, countMap.getOrDefault(key, 1) +1);
               max = Math.max(max, countMap.get(key));
            }
        }
        return max;
    }

    private int gcd(int a, int b) {
        return b== 0 ? a : gcd(b, a % b);
    }
    public static void main(String[] args) {
        int[][] points = new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}, };
        MaxPointOnLine149 prog = new MaxPointOnLine149();
        System.out.println(prog.maxPoints(points));

        points= new int[][]{{0,0},{4,5},{7,8},{8,9},{5,6},{3,4},{1,1}};
        System.out.println(prog.maxPoints(points));
    }
}
