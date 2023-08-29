package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets904 {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int max = 0;
        int left=0;
        for (int right=0; right < fruits.length;right++){
            count.put(fruits[right], count.getOrDefault(fruits[right], 0)+1);
            while (count.size() > 2){
                int fruit = fruits[left++];
                count.put(fruit, count.get(fruit)-1);
                if (count.get(fruit) ==0)
                    count.remove(fruit);
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
