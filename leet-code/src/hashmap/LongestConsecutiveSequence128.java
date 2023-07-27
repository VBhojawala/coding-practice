package hashmap;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence128 {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        int max = 0;
        int cur;

        for (int num : nums){
            numsSet.add(num);
        }

        for (int num : nums){
            if(!numsSet.contains(num-1)){
                cur = num + 1;
                while (numsSet.contains(cur)){
                    cur++;
                }
                max = Math.max(max, cur - num);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println("Longest Sequence : " + longestConsecutive(nums));
    }
}
