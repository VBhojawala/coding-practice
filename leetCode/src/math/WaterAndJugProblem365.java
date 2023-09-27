package math;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class WaterAndJugProblem365 {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity+ jug2Capacity < targetCapacity) return false;
        if (jug1Capacity == 0 || jug2Capacity == 0)
            return  targetCapacity == 0 || jug1Capacity + jug2Capacity == targetCapacity;
        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
    }

    private int gcd(int a, int b){
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public boolean canMeasureWaterDFS(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        int cur;
        int[] dirs = new int[]{jug1Capacity, jug2Capacity, -jug1Capacity, -jug2Capacity};
        while (!queue.isEmpty()){
            cur = queue.poll();
            if (cur == targetCapacity) return true;
            for (int d : dirs){
                if (visited.contains(cur+d) || cur < 0 || cur > targetCapacity)
                    continue;
                visited.add(cur+d);
                queue.offer(cur+d);
            }
        }
        return false;
    }
}
