package hashmap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall554 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int width;
        for (List<Integer> w : wall){
            width=0;
            for (int i=0;i<w.size() -1; i++){
                width +=w.get(i);
                countMap.merge(width, 1, Integer::sum);
            }
        }
        return wall.size() - (countMap.values().stream().max(Comparator.naturalOrder()).orElse(0));
    }
}
