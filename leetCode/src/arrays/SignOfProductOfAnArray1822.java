package arrays;

public class SignOfProductOfAnArray1822 {
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int num : nums){
            if (num == 0)
                return num;
            if (num < 0)
                sign *= -1;
        }
        return sign;
    }
}
