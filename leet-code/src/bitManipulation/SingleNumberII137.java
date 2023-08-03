package bitManipulation;

public class SingleNumberII137 {
    public int singleNumber(int[] nums) {
        int ans =0, count;

        for(int i=0; i<32;i++){
            count =0;
            for (int num: nums){
                count += ( (num >> i) & 1);
            }
            count = count % 3;
            ans |= count << i;
        }

        return ans;
    }
}
