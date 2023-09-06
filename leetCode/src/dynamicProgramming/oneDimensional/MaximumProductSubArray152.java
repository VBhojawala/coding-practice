package dynamicProgramming.oneDimensional;

public class MaximumProductSubArray152 {
    public int maxProduct(int[] nums) {
        int product =1;
        int max = Integer.MIN_VALUE;

        for (int num : nums){
            product *= num;
            max = Math.max(max, product);
            if (product == 0)
                product=1;
        }

        product = 1;
        for (int i=nums.length-1; i>=0; i--){
            product *= nums[i];
            max = Math.max(max, product);
            if (product == 0)
                product = 1;
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubArray152 prog = new MaximumProductSubArray152();
        System.out.println(prog.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(prog.maxProduct(new int[]{-2,0,-1}));
    }

}
