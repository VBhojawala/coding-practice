package stack;

import java.util.Stack;
import java.util.stream.Collector;

public class RemovingStarsFromAString2390 {


    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if (c == '*'){
                if (stack.peek() == '*')
                    stack.pop();
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        return stack.stream().collect(Collector.of(StringBuilder::new,
                StringBuilder::append, StringBuilder::append, StringBuilder::toString));
    }

    public static void main(String[] args) {
        RemovingStarsFromAString2390 prog = new RemovingStarsFromAString2390();
        System.out.println(prog.removeStars("leet**cod*e"));
        System.out.println(prog.removeStars("erase*****"));
    }

}
