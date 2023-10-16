package hashmap;

import java.util.HashMap;
import java.util.Map;

public class DetectSquares2013 {
    private Map<Integer, Map<Integer, Integer>> countMap;
    public DetectSquares2013() {
        countMap = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0] , y = point[1];
        countMap.computeIfAbsent(x, k -> new HashMap<>()).merge(y, 1, Integer::sum);
    }

    public int count(int[] point) {
        int x1 = point[0], y1 = point[1];
        if (!countMap.containsKey(x1)) return 0;

        int count = 0 , x2, distance;
        Map<Integer, Integer> countX1, countX2;

        for (var entry : countMap.entrySet()){
            x2 = entry.getKey();
            if (x2 != x1){
                distance = x2 - x1;
                countX1 = countMap.get(x1);
                countX2 = entry.getValue();

                count+= countX2.getOrDefault(y1, 0)
                        * countX1.getOrDefault(y1+distance, 0)
                        * countX2.getOrDefault(y1+distance, 0);

                count += countX2.getOrDefault(y1, 0)
                        * countX1.getOrDefault(y1-distance, 0)
                        * countX2.getOrDefault(y1-distance, 0);
            }
        }
        return count;

    }
}
