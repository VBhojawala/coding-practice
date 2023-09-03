package hashmap;

import java.util.HashMap;
import java.util.Map;

public class NumbersOfPairsOfInterchangeableRectangles2001 {
    public long interchangeableRectangles(int[][] rectangles) {
        long count =0;
        Double division;
        Map<Double, Integer> countMap = new HashMap<>();
        for (int[] rectangle : rectangles){
            division = rectangle[0] / (rectangle[1]*1.0);
            count += countMap.getOrDefault(division, 0);
            countMap.merge(division, 1, Integer::sum);
        }
        return count;
    }

}
