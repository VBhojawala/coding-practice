package heap;

import java.util.Arrays;

public class KClosestPointsToOrigin973 {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a,b)->{
            int dx = a[0] * a[0] + a[1] * a[1];
            int dy = b[0] * b[0] + b[1] * b[1];
            return dx -dy;
        });
        return Arrays.copyOfRange(points, 0, k);
    }

    public static void main(String[] args) {
        int[][] points = new int[][] {{3,3},{5,-1},{-2,4}};
        KClosestPointsToOrigin973 prog = new KClosestPointsToOrigin973();
        Arrays.stream(prog.kClosest(points, 2)).forEach(e-> Arrays.stream(e).forEach(System.out::println));
    }
}
