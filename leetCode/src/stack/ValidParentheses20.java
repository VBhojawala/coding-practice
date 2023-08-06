package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses20 {

    public static boolean isValid(String s) {
        Map<Character, Character> entryMap = new HashMap<>();
        entryMap.put('(', ')');
        entryMap.put('{', '}');
        entryMap.put('[', ']');

        Stack<Character> inputChars = new Stack<>();

        for(int i=0; i<s.length();i++){
            if(entryMap.containsKey(s.charAt(i))){
                inputChars.push(entryMap.get(s.charAt(i)));
            }else if(inputChars.isEmpty() || inputChars.pop() != s.charAt(i)){
                return false;
            }
        }
        if(!inputChars.isEmpty()){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println("Is valid ? : " + isValid(s));

        s = "(]";
        System.out.println("Is Valid ? : " + isValid(s));
    }
}
