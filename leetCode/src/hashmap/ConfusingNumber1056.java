package hashmap;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumber1056 {
    public boolean confusingNumber(int n) {
        Map<Integer, Integer> convMap = new HashMap<>();
        convMap.put(0,0);
        convMap.put(1,1);
        convMap.put(6,9);
        convMap.put(8,8);
        convMap.put(9,6);

        int cur = n, result = 0, d;

        while (cur > 0){
            d = cur % 10;
            if (!convMap.containsKey(d)) return false;
            result = (result * 10) + convMap.get(d);
            cur /= 10;
        }

        return result != n;
    }
}
