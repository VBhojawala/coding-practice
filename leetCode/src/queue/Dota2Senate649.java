package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dota2Senate649 {
    public String predictPartyVictory(String senate) {

        Deque<Integer> radiantQueue = new ArrayDeque<>();
        Deque<Integer> direQueue = new ArrayDeque<>();
        int n = senate.length();

        for (int i=0; i<n; i++){
            if (senate.charAt(i) == 'R')
                radiantQueue.offer(i);
            else
                direQueue.offer(i);
        }

        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()){
            if (radiantQueue.peek() < direQueue.peek())
                radiantQueue.offer(radiantQueue.peek() + n);
            else
                direQueue.offer(direQueue.peek() + n);
            radiantQueue.poll();
            direQueue.poll();
        }

        return radiantQueue.isEmpty() ? "Dire" : "Radiant";

    }

    public static void main(String[] args) {
        Dota2Senate649 prog = new Dota2Senate649();
        System.out.println(prog.predictPartyVictory("RD"));
        System.out.println(prog.predictPartyVictory("RDD"));
    }
}
