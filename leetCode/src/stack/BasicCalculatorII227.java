package stack;

import java.util.Stack;

public class BasicCalculatorII227 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num =0, n = s.length() - 1;

        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }

            if (i == n || c == '+' || c == '-' || c == '*'  || c == '/'){
                if (sign == '+')
                    stack.push(num);
                else if (sign == '-')
                    stack.push(-num);
                else if (sign == '*')
                    stack.push(stack.pop() * num);
                else if(sign == '/')
                    stack.push(stack.pop() / num);

                sign = c;
                num =0;

            }
        }

        int result = 0;
        while (!stack.empty())
            result += stack.pop();

        return result;
    }
}
