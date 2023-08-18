package stack;

import java.util.Stack;

public class BasicCalculator224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int result =0;
        int n= s.length();

        for (int i=0; i < n; i++){

            char c = s.charAt(i);

            if(Character.isDigit(c)){

                int j = i;
                int digit = 0;

                while (j < n && Character.isDigit(s.charAt(j))){
                    digit = (digit * 10) + s.charAt(j) - '0';
                    j++;
                }

                result += sign * digit;
                i = j-1;

            }
            else if (c == '+') {
                sign = 1;
            }
            else if (c == '-') {
                sign = -1;
            }
            else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if( c == ')') {
                result = stack.pop() * result + stack.pop();
            }
        }

        return  result;
    }

    public static void main(String[] args) {
        BasicCalculator224 prog = new BasicCalculator224();
        System.out.println(prog.calculate("1 + 1"));
        System.out.println(prog.calculate("2-1+2"));
        System.out.println(prog.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
