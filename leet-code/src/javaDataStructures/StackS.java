package javaDataStructures;

import java.util.ArrayDeque;
import java.util.Stack;

public class StackS {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(3);
        stack.push(4);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
