package stack;

import java.util.Stack;

public class Pattern132_456 {
    public boolean find132pattern(int[] nums) {
        int prev = Integer.MIN_VALUE, n=nums.length;
        Stack<Integer> stack = new Stack<>();

        for (int i=n-1;i>=0;i--){
            if (nums[i] < prev)
                return true;
            while (!stack.isEmpty() && stack.peek() < nums[i])
                prev = stack.pop();
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Pattern132_456 prog = new Pattern132_456();
        System.out.println(prog.find132pattern(new int[]{1,2,3,4}));
        System.out.println(prog.find132pattern(new int[]{3,1,4,2}));
        System.out.println(prog.find132pattern(new int[]{-1,3,2,0}));
    }
}
