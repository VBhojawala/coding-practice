package stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses1249 {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> invalidIndexes = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i < s.length(); i++){
            if (s.charAt(i) == '(')
                stack.push(i);
            else if (s.charAt(i) == ')'){
                if (stack.isEmpty())
                    invalidIndexes.add(i);
                else
                    stack.pop();
            }
        }

        while (!stack.isEmpty())
            invalidIndexes.add(stack.pop());

        StringBuilder result = new StringBuilder();

        for (int i=0; i<s.length(); i++){
            if (invalidIndexes.contains(i))
                continue;
            result.append(s.charAt(i));
        }

        return result.toString();
    }
}
