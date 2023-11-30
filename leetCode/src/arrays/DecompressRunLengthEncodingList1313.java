package arrays;

import java.util.Arrays;

public class DecompressRunLengthEncodingList1313 {
    public int[] decompressRLElist(int[] nums) {
        int n = nums.length, m =0;
        for (int i=0; i< nums.length; i += 2){
            m += nums[i];
        }

        int[] result = new int[m];
        int rIndex =0;

        for (int i=0; i < n; i += 2){
            Arrays.fill(result, rIndex, rIndex + nums[i], nums[i+1]);
            rIndex += nums[i];
        }

        return result;
    }
}
