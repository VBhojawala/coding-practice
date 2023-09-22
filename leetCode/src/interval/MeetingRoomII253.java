package interval;
import java.util.*;

public class MeetingRoomII253 {


    public int minMeetingRooms(int[][] intervals) {
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for (int i=0 ;i <intervals.length;i++){
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int count=0, max=0;
        int start=0, end=0;

        while (start < intervals.length){
            if (startTimes[start] < endTimes[end]){
                start++;count++;
                max = Math.max(max, count);
            }else {
                end++; count--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MeetingRoomII253 prog = new MeetingRoomII253();

    }
}
