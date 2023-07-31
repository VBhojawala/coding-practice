package interval;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons452 {
    public int findMinArrowShots(int[][] points) {
        int total=0;
        long last=Long.MIN_VALUE;
        Arrays.sort(points, Comparator.comparingInt(a->a[1]));

        for (int i=0; i< points.length; i++){
            if(points[i][0] > last){
                total++;
                last = points[i][1];
            }
        }
        return total;
    }

}
