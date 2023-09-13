package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberOfOccurrences1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr)
            countMap.merge(num, 1, Integer::sum);
        return new HashSet<>(countMap.values()).size() == countMap.size();
    }
}
