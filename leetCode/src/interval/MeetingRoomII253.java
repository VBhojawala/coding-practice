package interval;
import java.util.*;

public class MeetingRoomII253 {

    public static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int minMeetingRooms(List<Interval> intervals) {
        int[] startTimes = new int[intervals.size()];
        int[] endTimes = new int[intervals.size()];

        for (int i=0 ;i <intervals.size();i++){
            startTimes[i] = intervals.get(i).start;
            endTimes[i] = intervals.get(i).end;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int count=0, max=0;
        int start=0, end=0;

        while (start < intervals.size()){
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

        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0,30));
        intervals.add(new Interval(5,10));
        intervals.add(new Interval(15,20));
        System.out.println(prog.minMeetingRooms(intervals));

        intervals.clear();
        intervals.add(new Interval(2,7));
        System.out.println(prog.minMeetingRooms(intervals));

    }
}
