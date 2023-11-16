package interval;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges163 {

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0) {
            result.add(List.of(lower, upper));
            return result;
        }

        if (nums[0] > lower)
            result.add(List.of(lower, nums[0] -1));

        for (int i=1; i< n; i++){
            if (nums[i] - nums[i-1] > 1)
                result.add(List.of(nums[i-1] + 1 , nums[i] -1));
        }

        if (upper > nums[n-1])
            result.add(List.of(nums[n-1] +1, upper));

        return result;
    }

}
