package greedy;

import java.util.Arrays;
public class LargestNumber179 {
    public String largestNumber(int[] nums) {
        String[] numbers = new String[nums.length];
        for (int i=0;i<numbers.length;i++)
            numbers[i] = String.valueOf(nums[i]);

        Arrays.sort(numbers, (a,b)-> (b+a).compareTo(a+b));

        if (numbers[0].equals("0"))
            return "0";

        return String.join("", numbers);
    }

    public static void main(String[] args) {
        LargestNumber179 prog = new LargestNumber179();
        System.out.println(prog.largestNumber(new int[]{3,30,34,5,9}));
    }
}
