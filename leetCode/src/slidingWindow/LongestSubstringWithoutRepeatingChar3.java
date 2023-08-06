package slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar3 {

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()){
            return 0;
        }
        Set<Character> charWindow = new HashSet<>();
        int l=0;
        int r=0;
        int maxLength = 1;
        charWindow.add(s.charAt(0));

        while (++r < s.length()){
            if (!charWindow.contains(s.charAt(r))){
                charWindow.add(s.charAt(r));
                maxLength = Math.max(maxLength, r - l + 1);
            }else {
                while (charWindow.contains(s.charAt(r))){
                    charWindow.remove(s.charAt(l++));
                }
                charWindow.add(s.charAt(r));
            }
        }
        return  maxLength;
    }
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println("Longest Sequence : " + lengthOfLongestSubstring(s));

    }
}
