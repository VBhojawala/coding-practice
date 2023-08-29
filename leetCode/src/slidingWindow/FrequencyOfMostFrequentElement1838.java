package slidingWindow;

import java.util.Arrays;

public class FrequencyOfMostFrequentElement1838 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0, result=0;
        long total=0;

        for (int right=0;right<nums.length; right++){
            total += nums[right];

            while (nums[right] * (right - left + 1) > total + k)
                   total-=nums[left++];

            result = Math.max(result, right - left +1);
        }

        return result;
    }

    public static void main(String[] args) {
        FrequencyOfMostFrequentElement1838 prog = new FrequencyOfMostFrequentElement1838();
        System.out.println(prog.maxFrequency(new int[]{1,2,4}, 5));
        System.out.println(prog.maxFrequency(new int[]{1,4,8,13}, 5));
        System.out.println(prog.maxFrequency(new int[]{3,9,6}, 2));
    }
}
