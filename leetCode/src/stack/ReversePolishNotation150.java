package stack;

import java.util.Stack;

public class ReversePolishNotation150 {

    public static int evalRPN(String[] tokens) {
        int x, y;
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            if(token.length() > 1 || Character.isDigit(token.charAt(0))){
                stack.push(Integer.parseInt(token));
            }else {
                y = stack.pop();
                x = stack.pop();

                if(token.equals("+"))
                    stack.push(x+y);
                if(token.equals("-"))
                    stack.push(x-y);
                if(token.equals("/"))
                    stack.push(x / y);
                if(token.equals("*"))
                    stack.push(x * y);
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("Answer : " + evalRPN(tokens));
    }
}
