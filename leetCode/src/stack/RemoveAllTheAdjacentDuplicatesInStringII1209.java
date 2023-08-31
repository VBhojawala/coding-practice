package stack;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAllTheAdjacentDuplicatesInStringII1209 {

    class Char{
        char aChar;
        int count;

        public Char(char aChar, int count) {
            this.aChar = aChar;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Deque<Char> stack = new LinkedList<>();
        char cur;
        for (int i=0; i<s.length();i++){
            cur = s.charAt(i);
            if (!stack.isEmpty() && stack.peek().aChar == cur){
                stack.peek().count++;
            }else {
                stack.push(new Char(cur, 1));
            }
            if (stack.peek().count == k)
                stack.pop();
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            Char c = stack.pollLast();
            result.append((c.aChar+"").repeat(c.count));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        RemoveAllTheAdjacentDuplicatesInStringII1209 prog =new RemoveAllTheAdjacentDuplicatesInStringII1209();
        System.out.println(prog.removeDuplicates("abcd", 2));
        System.out.println(prog.removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(prog.removeDuplicates("pbbcggttciiippooaais", 2));
    }
}
