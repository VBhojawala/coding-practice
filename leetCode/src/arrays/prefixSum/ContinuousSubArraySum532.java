package arrays.prefixSum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContinuousSubArraySum532 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> modSet = new HashSet<>();
        int curSum=0, prevRem=0, curRem=0;
        for (int num : nums){
            curSum = prevRem + num;
            curRem = curSum % k;
            if (modSet.contains(curRem))
                return true;
            modSet.add(prevRem);
            prevRem = curRem;
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
