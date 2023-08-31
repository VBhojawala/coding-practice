package stack.monotonic;

import java.util.Stack;
import java.util.stream.Collector;

public class RemoveKDigits402 {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int digit;
        for (int i=0; i<num.length();i++){
            digit = num.charAt(i) - '0';
            while (k >0 && !stack.isEmpty() && stack.peek() > digit){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty())
            result.append(stack.pop()+"");
        result.reverse();
        result.delete(result.length()-k, result.length());
        while (result.length() > 1 && result.charAt(0) == '0')
            result.deleteCharAt(0);

        return result.toString().isEmpty() ? "0" : result.toString();

    }

    public static void main(String[] args) {
        RemoveKDigits402 prog = new RemoveKDigits402();
        System.out.println(prog.removeKdigits("112", 1));
        System.out.println(prog.removeKdigits("10200", 1));
        System.out.println(prog.removeKdigits("10", 2));
    }
}
