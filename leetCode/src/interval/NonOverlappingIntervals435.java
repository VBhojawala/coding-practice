package interval;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int prevEnd = intervals[0][1], count =0;
        for (int i=1; i< intervals.length; i++){
            if (intervals[i][0] >= prevEnd)
                prevEnd = intervals[i][1];
            else
                count++;
        }
        return count;
    }
}
