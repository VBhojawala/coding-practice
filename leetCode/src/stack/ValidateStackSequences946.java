package stack;

import java.util.Stack;

public class ValidateStackSequences946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int p=0, n= pushed.length;
        for (int e : pushed){
            stack.push(e);
            while (p < n && popped[p] == stack.peek()){
                stack.pop();
                p++;
            }
        }
        return stack.size() == 1  && p==n;
    }

    public static void main(String[] args) {
        ValidateStackSequences946 prog = new ValidateStackSequences946();
        System.out.println(prog.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        System.out.println(prog.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
        System.out.println(prog.validateStackSequences(new int[]{0,2,1}, new int[]{0,1,2}));
    }
}
