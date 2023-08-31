package stack.monotonic;

import java.util.Stack;

public class OnlineStockSpan901 {
    class Stock{
        int price;
        int span;

        public Stock(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }

    Stack<Stock> monStack;
    public OnlineStockSpan901() {
        monStack= new Stack<>();
    }
    public int next(int price) {
        int span =1;
        while (!monStack.isEmpty() && monStack.peek().price <= price)
            span+= monStack.pop().span;
        monStack.push(new Stock(price, span));
        return span;
    }

    public static void main(String[] args) {
        OnlineStockSpan901 prog = new OnlineStockSpan901();
        System.out.println(prog.next(100));
        System.out.println(prog.next(80));
        System.out.println(prog.next(60));
        System.out.println(prog.next(70));
        System.out.println(prog.next(60));
        System.out.println(prog.next(75));
        System.out.println(prog.next(85));
    }
}
