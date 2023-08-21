import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Snippet {
    public static class Interval {
        int length;
        int end;
    }
    public static void main(String[] args) {
        // Join String of Arrays
        String.join(" ", new ArrayList<>());

        // Sort Array By Index
        int[][] points = new int[2][2];
        Arrays.sort(points, Comparator.comparingInt(a->a[1]));

        // Max Heap (MaxPQ)
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());

        // Comparator Ordering
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(Comparator.comparingInt(i -> i.length));

        // Sort array and return copy
        int[] queries = new int[5];
        IntStream.of(queries).sorted().toArray();

        // BitWise
        // n & 1   ==> get Last Digit
        // n >>> 1 ==> unsigned right shift
        // n >>    ==> Signed rightShift
        // n & n-1 ==> remove 1 binary from digit

        // Positive Inf
        final int INF = 0x3f3f3f3f;

    }
}
