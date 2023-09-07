package dynamicProgramming.oneDimensional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn740 {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums)
            countMap.merge(num, 1, Integer::sum);
        int prev1=0, prev2=0, cur, temp;
        Integer[] sorted = countMap.keySet().toArray(new Integer[0]);
        Arrays.sort(sorted);
        for (int i =0; i<sorted.length; i++){
            cur = sorted[i] * countMap.get(sorted[i]);
            if (i> 0 && sorted[i] == sorted[i-1]+1){
                temp = prev1;
                prev1 = Math.max(cur + prev2, prev1);
                prev2 = temp;
            }else {
                prev2 = prev1;
                prev1 += cur;
            }
        }
        return prev1;
    }

    public static void main(String[] args) {
        DeleteAndEarn740 prog = new DeleteAndEarn740();
        System.out.println(prog.deleteAndEarn(new int[]{3,4,2}));
        System.out.println(prog.deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
}
