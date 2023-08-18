package arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i=0, prev =1 ; i< n; i++){
            result[i] = prev;
            prev *= nums[i];
        }

        for (int j=n-1, prev=1; j>=0; j--){
            result[j] *= prev;
            prev *= nums[j];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf238 prog = new ProductOfArrayExceptSelf238();
        Arrays.stream(prog.productExceptSelf(new int[]{-1,1,0,-3,3})).forEach(System.out::println);
    }
}
