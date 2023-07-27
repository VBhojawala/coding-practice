package stack;

import java.util.Stack;

public class MinStack155 {

    Stack<Integer> stack ;
    Stack<Integer> minStack;
    public MinStack155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        }else {
            if(minStack.peek() < val){
                minStack.push(minStack.peek());
            }else{
                minStack.push(val);
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
    public static void main(String[] args) {


    }
}
