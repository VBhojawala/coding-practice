package bitManipulation;

public class MissingNumber268 {
    public int missingNumber(int[] nums) {
        int sum = nums.length;
        for (int i= sum -1; i>=0; i--)
            sum += i - nums[i];
        return sum;
    }

    public static void main(String[] args) {
        MissingNumber268 prog = new MissingNumber268();
        System.out.println(prog.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
