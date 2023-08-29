package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString76 {

    public static String minWindow(String s, String t) {
        int[] target = new int[128];
        int[] widow = new int[128];
        int m = s.length(), n= t.length();
        for (int i=0;i<n;i++)
            target[t.charAt(i)]++;

        int count=0, left=0, max = Integer.MAX_VALUE, startIndex=-1;

        for (int right=0; right< m;right++){

            widow[s.charAt(right)]++;

            if (target[s.charAt(right)] >= widow[s.charAt(right)]){
                count++;
            }

            while (count == n){
                if ((right - left +1) < max){
                    max = right-left + 1;
                    startIndex = left;
                }
                if (target[s.charAt(left)] >= widow[s.charAt(left)]){
                    count--;
                }
                widow[s.charAt(left++)]--;
            }
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex+max);
    }


    public static void main(String[] args) {

        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println("Substring : " + minWindow(s, t));


    }
}
