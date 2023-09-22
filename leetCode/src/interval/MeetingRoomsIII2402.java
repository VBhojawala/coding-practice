package interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsIII2402 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0]-b[0] );
        PriorityQueue<int[]> busy = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> idle = new PriorityQueue<>();

        for (int i=0; i<n; i++)
            idle.offer(i);

        int[] count = new int[n];
        int start, end, room;
        int[] c;

        for (int[] meeting : meetings){
            start = meeting[0] ; end = meeting[1];

            while (!busy.isEmpty() && busy.peek()[0] <= start)
                idle.offer(busy.poll()[1]);

            if (!idle.isEmpty()){
                room = idle.poll();
                busy.offer(new int[]{end, room});
            }else {
               c = busy.poll();
               room = c[1];
               busy.offer(new int[]{c[0] + (end - start),room});
            }

            count[room]++;
        }

        int max =0;
        for (int i=0 ; i < n ; i++){
            if (count[max] < count[i])
                max =i;
        }

        return max;
    }

    public static void main(String[] args) {

        int[][] meetings = new int[][]{{1,20},{2,10},{3,5},{4,9},{6,8}};
        MeetingRoomsIII2402 prog= new MeetingRoomsIII2402();

        System.out.println(prog.mostBooked(2, meetings));
        meetings = new int[][] {{0,10},{1,5},{2,7},{3,4}};
        System.out.println(prog.mostBooked(2, meetings));
    }
}
