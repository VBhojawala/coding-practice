package arrays.string;

import java.util.PriorityQueue;

public class ReorganizeString767 {
    public String reorganizeString(String s) {
        int[] charCount = new int[26];
        for (char ch : s.toCharArray())
            charCount[ch-'a']++;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> b[1]- a[1]);
        for (int i=0; i<26; i++){
            if (charCount[i] > 0)
                heap.offer(new int[]{i+'a', charCount[i]});
        }

        StringBuilder result = new StringBuilder();

        while (!heap.isEmpty()){
            var first = heap.poll();
            if (result.isEmpty() || result.charAt(result.length()-1) != first[0]){
                result.append((char) first[0]);
                if (--first[1] > 0)
                    heap.offer(first);
            }else {
                if (heap.isEmpty()) return  "";
                var second = heap.poll();
                result.append((char) second[0]);
                if (--second[1] > 0)
                    heap.offer(second);
                heap.offer(first);
            }
        }
        return result.toString();
    }
}
