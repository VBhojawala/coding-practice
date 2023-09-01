package arrays;

public class ConcatenationOfArrays1929 {
    public int[] getConcatenation(int[] nums) {
        int n= nums.length;
        int[] result = new int[n*2];

        for (int i=0;i<n;i++){
            result[i] = nums[i];
            result[i+n] = nums[i];
        }
        return result;
    }

}
