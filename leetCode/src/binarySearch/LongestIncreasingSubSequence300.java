package binarySearch;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubSequence300 {

    private List<Integer> sequence;
    public int lengthOfLIS(int[] nums) {
        sequence = new ArrayList<>();
        sequence.add(nums[0]);
        for (int i=1;i<nums.length;i++){
            if (nums[i] > sequence.get(sequence.size()-1))
                sequence.add(nums[i]);
            else
                sequence.set(binarySearch(nums[i]), nums[i]);
        }
        return sequence.size();
    }

    private int binarySearch(int x){
        int left = 0, right = sequence.size() -1, mid;

        while (left < right){
            mid = left + (right - left) /  2;
            if (sequence.get(mid) >= x)
                right= mid;
            else
                left = mid+1;
        }
        return left;
    }
    public static void main(String[] args) {
        LongestIncreasingSubSequence300 prog = new LongestIncreasingSubSequence300();
        System.out.println(prog.lengthOfLIS(new int[]{0,3,1,6,2,2,7}));
        System.out.println(prog.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(prog.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }

}
