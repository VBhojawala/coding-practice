package hashmap;

import java.util.HashMap;
import java.util.Map;

public class FindAnagramMappings760 {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums2Map = new HashMap<>();
        int n = nums2.length;

        for (int i=0; i< n; i++){
            nums2Map.put(nums2[i], i);
        }

        int[] mappings = new int[n];

        for (int i=0; i < n; i++){
            mappings[i] = nums2Map.get(nums1[i]);
        }

        return mappings;
    }
}
