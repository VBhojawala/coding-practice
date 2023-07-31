package arrays;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger13 {
    public int romanToInt(String s) {
        Map<Character, Integer> charMap = new HashMap<>();

        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);

        int sum = charMap.get(s.charAt(s.length()-1));
        int sign = 1;
        for (int i=0;i<s.length()-1;i++){
            if(charMap.get(s.charAt(i)) < charMap.get(s.charAt(i+1)))
                sign = -1;
            else
                sign = 1;
            sum += charMap.get(s.charAt(i)) * sign;
        }
        return  sum;
    }
}
