package heap;

import java.util.*;

public class HighFive1086 {

    public int[][] highFive(int[][] items) {
        Map<Integer, Queue<Integer>> idMap = new TreeMap<>();

        for (int[] item : items)
            idMap.computeIfAbsent(item[0], k-> new PriorityQueue<>(Comparator.reverseOrder())).offer(item[1]);

        int[][] result = new int[idMap.size()][];
        int rp =0;
        for (int id : idMap.keySet()){
            Queue<Integer> scores = idMap.get(id);
            int avg =0;
            for (int i=0; i<5;i++)
                avg+=scores.poll();
            avg /= 5;
            result[rp++] = new int[]{id, avg};
        }
        return result;
    }

    public static void main(String[] args) {
        HighFive1086 prog = new HighFive1086();
        int[][] result = prog.highFive(new int[][]  {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}});
        System.out.println(result);
    }
}
