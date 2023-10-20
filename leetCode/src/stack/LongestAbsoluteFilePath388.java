package stack;

import java.util.Stack;

public class LongestAbsoluteFilePath388 {

    public int lengthLongestPath(String input) {
        int n = input.length(), i =0, maxLength=0;
        Stack<Integer> stack = new Stack<>();

        int indent, cur;
        boolean isFile;

        while (i < n){
            indent =0;
            for (; input.charAt(i) == '\t'; i++)
                indent++;

            cur =0;
            isFile = false;

            for (; i<n && input.charAt(i) != '\n'; i++){
                cur++;
                if (input.charAt(i) == '.')
                    isFile = true;
            }
            i++;

            while (!stack.isEmpty() && stack.size() > indent)
                stack.pop();

            if (stack.size() > 0)
                cur += stack.peek() + 1;

            if (isFile){
                maxLength = Math.max(maxLength, cur);
            }else {
                stack.push(cur);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestAbsoluteFilePath388 prog = new LongestAbsoluteFilePath388();
        System.out.println(prog.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}
