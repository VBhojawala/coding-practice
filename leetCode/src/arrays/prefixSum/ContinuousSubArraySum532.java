package arrays.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum532 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum =0, rem;
        for (int i=0;i<nums.length;i++){
            sum += nums[i];
            rem = sum % k;

            if (map.containsKey(rem) && (i - map.get(rem)) > 1 )
                return true;

            if (!map.containsKey(rem))
                map.put(rem, i);
        }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubArraySum532 prog = new ContinuousSubArraySum532();
        System.out.println(prog.checkSubarraySum(new int[]{23,2,4,6,7}, 6));
        System.out.println(prog.checkSubarraySum(new int[]{23,2,6,4,7}, 6));
        System.out.println(prog.checkSubarraySum(new int[]{23,2,6,4,7}, 13));
    }
}
