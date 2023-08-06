package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class subStringWithConcatenationOFAllWords30 {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> match = new ArrayList<>();

        Map<String, Integer> wordsMap = new HashMap<>();
        Map<String, Integer> windowMap;

        for(String word : words){
           wordsMap.merge(word, 1, Integer::sum);
        }

        int wordSize = words[0].length();
        int windowSize =wordSize * words.length;
        int l=0;
        int r = windowSize;

        boolean isMatch;

        while (r <= s.length()){
            isMatch = true;
            windowMap = new HashMap<>();

            for(int i=l; i < l+windowSize; i=i+wordSize){
                if(!wordsMap.containsKey(s.substring(i, i+wordSize))){
                    isMatch = false;
                    break;
                }else {
                    windowMap.merge(s.substring(i, i+wordSize), 1, Integer::sum);
                }
            }
            if(isMatch && wordsMap.equals(windowMap)){
                match.add(l);
            }
            l++; r++;
        }
        return match;
    }

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};

        System.out.println("Found Substring ? :" + findSubstring(s, words));
    }

}
