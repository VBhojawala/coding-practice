package hashmap;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter359 {

    private Map<String, Integer> limiterMap;
    public LoggerRateLimiter359() {
        limiterMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (limiterMap.getOrDefault(message, 0) > timestamp)
            return false;
        limiterMap.put(message, timestamp + 10);
        return true;
    }
}
