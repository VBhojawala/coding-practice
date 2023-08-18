package arrays;

public class TrappingRainWater42 {
    public int trap(int[] height) {
        int n=height.length;
        int left=0, right = n-1;
        int leftMax = height[left], rightMax= height[right];
        int total =0;

        while (left < right){
            if (leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                total += leftMax - height[left];
            }else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                total += rightMax - height[right];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        TrappingRainWater42 prog = new TrappingRainWater42();
        System.out.println(prog.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
