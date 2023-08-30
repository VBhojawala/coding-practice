package stack;

import java.util.Stack;

public class DecodeString394 {

    public String decodeString(String s) {
        Stack<String> wordStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int n= s.length(), left, count = 0;
        String result = "";
        for (int right=0; right < n;right++){
            left=right;
            if (Character.isDigit(s.charAt(right))){
                while (right < n && Character.isDigit(s.charAt(right)))
                    right++;
                count = Integer.parseInt(s.substring(left, right--));
            }
            else if(Character.isLetter(s.charAt(right))){
                while (right < n && Character.isLetter(s.charAt(right)))
                    right++;
                result += s.substring(left, right--);
            }
            else if (s.charAt(right) == '['){
                wordStack.push(result);
                countStack.push(count);
                result = "";
                count = 0;
            }else if (s.charAt(right) == ']') {
                result = wordStack.pop() + result.repeat(countStack.pop());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DecodeString394 prog = new DecodeString394();
//        System.out.println(prog.decodeString("3[a]2[bc]"));
//        System.out.println(prog.decodeString("3[a2[c]]"));
        System.out.println(prog.decodeString("2[abc]3[cd]ef"));
    }

}
