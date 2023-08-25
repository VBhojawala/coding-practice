package binaryTree.segmentTree;

import java.util.TreeMap;

public class MyCalendarI729 {

    TreeMap<Integer, Integer> bookings;
    public MyCalendarI729() {
        bookings = new TreeMap<>();
        bookings.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public boolean book(int start, int end) {
        boolean isAlreadyBooked = bookings.get(bookings.higherKey(start)) < end;
        if (!isAlreadyBooked) bookings.put(end, start);
        return !isAlreadyBooked;
    }

    public static void main(String[] args) {
        MyCalendarI729 prog = new MyCalendarI729();
        System.out.println(prog.book(10,20));
        System.out.println(prog.book(15,25));
        System.out.println(prog.book(20,30));
    }
}
