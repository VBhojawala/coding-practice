package javaDataStructures;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQ {

    public static void main(String[] args) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());

        maxPQ.add(5);
        maxPQ.add(7);
        maxPQ.add(9);
        maxPQ.add(2);

        while (!maxPQ.isEmpty()){
            System.out.println(maxPQ.poll());
        }

    }
}
