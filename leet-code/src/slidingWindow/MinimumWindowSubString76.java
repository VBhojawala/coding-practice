package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString76 {

    public static String minWindow(String s, String t) {

        if (s.isEmpty())
            return s;

        Map<Character, Integer> curWindow = new HashMap<>();
        Map<Character, Integer> targetSet = new HashMap<>();

        for(int i =0; i< t.length(); i++){
            if(targetSet.containsKey(t.charAt(i))){
                targetSet.put(t.charAt(i), targetSet.get(t.charAt(i)) + 1 );
            }
            else {
                targetSet.put(t.charAt(i), 1);
            }
        }

        int l =0;
        int size = t.length();
        String result = "";
        int minLength =  Integer.MAX_VALUE;
        for(int r=0; r < s.length(); r++){

            if(targetSet.containsKey(s.charAt(r))){
                if(curWindow.containsKey(s.charAt(r))){
                    curWindow.put(s.charAt(r), curWindow.get(s.charAt(r)) + 1 );
                }
                else {
                    curWindow.put(s.charAt(r), 1);
                }
            }

            while (curWindow.size() == targetSet.size() && compareMaps(curWindow, targetSet)){
                if(curWindow.containsKey(s.charAt(l))){
                    if (curWindow.get(s.charAt(l)) == 1)
                        curWindow.remove(s.charAt(l));
                    else
                        curWindow.put(s.charAt(l), curWindow.get(s.charAt(l)) - 1 );
                }
                if((r - l +1) < minLength){
                    minLength = r - l +1;
                    result = s.substring(l, r+1);
                }
                l++;
            }

        }
        return  result;
    }

    private static boolean compareMaps(Map<Character, Integer> s, Map<Character, Integer> t){
        for (Character c: t.keySet()){
            if(s.get(c) < t.get(c))
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        String s = "AA", t = "AA";
        System.out.println("Substring : " + minWindow(s, t));


    }
}
