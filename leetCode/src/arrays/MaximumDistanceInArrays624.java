package arrays;

import java.util.List;

public class MaximumDistanceInArrays624 {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = 0;
        int min = arrays.get(0).get(0), curMin;
        int max = arrays.get(0).get(arrays.get(0).size() - 1), curMax;
        List<Integer> curr;
        for (int i=1; i < arrays.size(); i++){
            curr = arrays.get(i);
            curMin = Math.abs(curr.get(0) - max);
            curMax = Math.abs(curr.get(curr.size() -1) - min);
            result = Math.max(result, Math.max(curMin, curMax));
            min = Math.min(min, curr.get(0));
            max = Math.max(max, curr.get(curr.size() -1));
        }

        return result;
    }
}
