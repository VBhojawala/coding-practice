package arrays;

public class HowManyNumbersAreSmallerThanTheCurrentNumber1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[102];
        for (int n : nums){
            count[n+1]++;
        }

        for (int i=1; i< count.length; i++){
            count[i] += count[i-1];
        }

        int n = nums.length;
        int[] result = new int[n];

        for (int i=0; i<n;i++){
            result[i] = count[nums[i]];
        }

        return result;
    }
}
