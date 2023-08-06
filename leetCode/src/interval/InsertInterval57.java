package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval57 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean isInserted = false;

        for(int cur=0; cur<intervals.length; cur++){
            if(isInserted){
                result.add(new int[]{intervals[cur][0], intervals[cur][1]});
            }
            else {
                if (newInterval[1] < intervals[cur][0]){
                    isInserted = true;
                    result.add(new int[]{newInterval[0], newInterval[1]});
                    result.add(intervals[cur]);
                }else if(intervals[cur][1]< newInterval[0]){
                    result.add(new int[]{intervals[cur][0], intervals[cur][1]});
                }else {
                    newInterval[0] = Math.min(newInterval[0], intervals[cur][0]);
                    newInterval[1] = Math.max(newInterval[1], intervals[cur][1]);
                }
            }
        }
        if (!isInserted){
            result.add(new int[]{newInterval[0], newInterval[1]});
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        Arrays.stream(insert(intervals, newInterval)).forEach(a->{
            System.out.println(a[0] + "-> " + a[1]);
        });

        intervals = new int[][]{{1,3},{6,9}};
        newInterval = new int[]{2,5};

        Arrays.stream(insert(intervals, newInterval)).forEach(a->{
            System.out.println(a[0] + "-> " + a[1]);
        });
    }
}
