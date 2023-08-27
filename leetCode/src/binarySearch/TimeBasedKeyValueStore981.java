package binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore981 {

    public class Value{
        String value;
        int timestamp;

        public Value(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Value>> timeMap;
    public TimeBasedKeyValueStore981() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, e-> new ArrayList<>()).add(new Value(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key))
            return "";
        return binarySearch(timeMap.get(key), timestamp);
    }

    public String binarySearch(List<Value> values,  int timestamp){
        int left =0, right= values.size() -1, mid;
        Value floor = null;
        while (left <= right){

            mid = (right + left) >> 1;

            if (values.get(mid).timestamp <= timestamp) {
                floor = values.get(mid);
                left = mid + 1;
            }else {
               right = mid -1;
            }

        }
        return floor == null ? "" : floor.value;
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore981 prog = new TimeBasedKeyValueStore981();
        prog.set("foo","bar", 1);
        System.out.println(prog.get("foo", -1));
        System.out.println(prog.get("foo", 3));
        prog.set("foo","bar2", 4);
        System.out.println(prog.get("foo", 4));
        System.out.println(prog.get("foo", 5));
        prog.set("love","high",10);
        prog.set("love","low",20);
        System.out.println(prog.get("love", 5));
        System.out.println(prog.get("love", 10));
        System.out.println(prog.get("love", 15));
        System.out.println(prog.get("love", 20));
        System.out.println(prog.get("love", 25));
    }
}
