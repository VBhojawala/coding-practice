package hashmap;

import java.util.*;

public class MaximumAreaRectangle939 {

    private static Integer PRIME = 40001;
    public int minAreaRect(int[][] points) {
        TreeMap<Integer, List<Integer>> rows = new TreeMap<>();
        for (int[] point: points){
            rows.computeIfAbsent(point[0], e -> new ArrayList<>()).add(point[1]);
        }

        int minArea = Integer.MAX_VALUE, y1, y2, hash;
        Map<Integer, Integer> lastX = new HashMap<>();
        List<Integer> row;
        for (int x : rows.keySet()){
            row = rows.get(x);
            Collections.sort(row);
            for (int i=0; i<row.size(); i++){
                for (int j= i+1; j<row.size(); j++){
                    y1 = row.get(i); y2 = row.get(j);
                    hash =  PRIME * y1 + y2;
                    if (lastX.containsKey(hash))
                        minArea = Math.min(minArea, (x - lastX.get(hash)) * ( y2 - y1));
                    lastX.put(hash, x);
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}
