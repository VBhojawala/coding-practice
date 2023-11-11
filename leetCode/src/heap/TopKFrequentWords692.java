package heap;

import java.util.*;

public class TopKFrequentWords692 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words)
            wordCountMap.merge(word, 1, Integer::sum);

        Queue<String> heap = new PriorityQueue<>((a,b) ->{
            int diff = wordCountMap.get(a) - wordCountMap.get(b);
            return diff == 0 ? b.compareTo(a) : diff;
        });

        for (String word : wordCountMap.keySet()){
            heap.offer(word);
            if (heap.size() > k)
                heap.poll();
        }

        LinkedList<String> result = new LinkedList<>();
        while (!heap.isEmpty())
            result.addFirst(heap.poll());

        return result;
    }

}
