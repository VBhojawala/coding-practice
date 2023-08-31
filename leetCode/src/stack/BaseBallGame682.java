package stack;

import java.util.Stack;

public class BaseBallGame682 {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String operation : operations){
            if (operation.equals("C"))
                stack.pop();
            else if (operation.equals("D"))
                stack.push(stack.peek()*2);
            else if (operation.equals("+")){
                int s1 = stack.pop();
                int s2 = stack.peek();
                stack.push(s1);
                stack.push(s1+s2);
            }
            else
                stack.push(Integer.valueOf(operation));
        }
        return stack.stream().mapToInt(Integer::valueOf).sum();
    }

    public static void main(String[] args) {
        BaseBallGame682 prog = new BaseBallGame682();
        System.out.println(prog.calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(prog.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
        System.out.println(prog.calPoints(new String[]{"1","C"}));
    }
}
