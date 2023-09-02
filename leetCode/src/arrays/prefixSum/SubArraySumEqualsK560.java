package arrays.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0,1);
        int result=0, sum=0;
        for (int num: nums){
            sum += num;
            result += countMap.getOrDefault(sum-k, 0);
            countMap.merge(sum, 1, Integer::sum);
        }
        return result;
    }

    public static void main(String[] args) {
        SubArraySumEqualsK560 prog = new SubArraySumEqualsK560();
        System.out.println(prog.subarraySum(new int[]{1,1,1}, 2));
        System.out.println(prog.subarraySum(new int[]{1,2,3}, 3));
    }
}
