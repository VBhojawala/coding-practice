package interval;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class MeetingRoom252 {
    public static class Interval {
     int start, end;
     Interval(int start, int end) {
         this.start = start;
         this.end = end;
     }
    }
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparing(i->i.start));
        for (int i=0; i<intervals.size() -2; i++){
            if (intervals.get(i).end > intervals.get(i+1).start)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRoom252 prog = new MeetingRoom252();

        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0,30));
        intervals.add(new Interval(15,20));
        intervals.add(new Interval(5,10));


        System.out.println(prog.canAttendMeetings(intervals));

        intervals.clear();
        intervals.add(new Interval(5,8));
        intervals.add(new Interval(9,15));

        System.out.println(prog.canAttendMeetings(intervals));
    }
}
