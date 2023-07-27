package hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {

    public static boolean wordPattern(String pattern, String s) {

        Map<Character, String> patternMap = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();

        String[] words = s.split(" ");

        if(words.length != pattern.length()){
            return false;
        }

        Character curPattern ;
        String curWord;

        for(int i=0; i< pattern.length(); i++){
            curPattern = pattern.charAt(i);
            curWord = words[i];

            if(!patternMap.getOrDefault(curPattern, curWord).equals(curWord) ||
            sMap.getOrDefault(curWord, curPattern) != curPattern){
                return false;
            }

            patternMap.put(curPattern, curWord);
            sMap.put(curWord, curPattern);
        }
        return true;

    }

    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println("Match ? : " + wordPattern(pattern, s));
    }
}
