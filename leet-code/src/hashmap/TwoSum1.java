package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> curNums = new HashMap<>();
        int diff;

        for(int i=0; i < nums.length; i++){
            diff = target - nums[i];
            if (curNums.containsKey(diff))
                return new int[]{curNums.get(diff), i};
            curNums.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
       Arrays.stream(twoSum(nums, 6)).forEach(System.out::println);
    }
}
