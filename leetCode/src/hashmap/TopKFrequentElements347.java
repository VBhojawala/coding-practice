package hashmap;

import java.util.*;

public class TopKFrequentElements347 {


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums)
            count.put(num, count.getOrDefault(num, 0)+1);

        List<List<Integer>> freq = new ArrayList<>();
        for (int i=0;i<=nums.length;i++)
            freq.add(new ArrayList<>());

        for (int key : count.keySet())
            freq.get(count.get(key)).add(key);

        int result[] = new int[k];
        int f=nums.length, i=0;
        while (i<k){
            while (freq.get(f).size() == 0)
                f--;
            result[i++] = freq.get(f).remove(0);
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements347 prog = new TopKFrequentElements347();
        Arrays.stream(prog.topKFrequent(new int[]{1,1,1,2,2,3}, 2)).forEach(System.out::println);
        Arrays.stream(prog.topKFrequent(new int[]{1}, 1)).forEach(System.out::println);
    }
}
