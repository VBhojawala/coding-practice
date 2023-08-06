package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval56 {

    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int left;

        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));

        for (int right=0; right < intervals.length; right++){
            left= right;

            while (right +1 < intervals.length && intervals[left][1] >= intervals[right+1][0]){
                right++;
                if(intervals[left][1] < intervals[right][1] ){
                    intervals[left][1] = intervals[right][1];
                }
            }
            result.add(new int[]{intervals[left][0],intervals[left][1]});
        }
        return result.toArray(new int[result.size()][]);

    }

    public static void main(String[] args) {
        int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        Arrays.stream(merge(intervals)).forEach(a->{
            System.out.println(a[0] + "-> " + a[1]);
        });

        intervals  = new int[][]{{1, 4}, {0,2}, {3,5}};
        Arrays.stream(merge(intervals)).forEach(a->{
            System.out.println(a[0] + "-> " + a[1]);
        });

    }
}
