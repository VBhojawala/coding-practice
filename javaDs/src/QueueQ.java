import java.util.ArrayDeque;
import java.util.Queue;

public class QueueQ {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(5);
        queue.add(2);
        queue.add(6);

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
