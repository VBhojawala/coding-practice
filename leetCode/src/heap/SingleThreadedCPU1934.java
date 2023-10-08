package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCPU1934 {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sortedTask = new int[n][3];

        for (int i=0;i<n;i++)
            sortedTask[i] = new int[]{tasks[i][0], tasks[i][1], i};

        Arrays.sort(sortedTask, (a,b) -> a[0] - b[0]);

        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] taskSchedule = new int[n], nextTask;
        int curIndex = 0, curTime = 0, taskIndex=0;

        while (!heap.isEmpty() || curIndex < n){
            if (heap.isEmpty())
                curTime = Math.max(curTime, sortedTask[curIndex][0]);

            while (curIndex < n && sortedTask[curIndex][0] < curTime){
                heap.offer(new int[]{sortedTask[curIndex][1], sortedTask[curIndex][2]});
                curIndex++;
            }

            nextTask = heap.poll();
            taskSchedule[taskIndex++] = nextTask[1];
            curTime += nextTask[0];

        }

        return  taskSchedule;
    }
}
