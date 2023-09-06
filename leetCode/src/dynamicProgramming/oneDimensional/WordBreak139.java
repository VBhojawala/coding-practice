package dynamicProgramming.oneDimensional;

import java.util.Arrays;
import java.util.List;

public class WordBreak139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] isWordBreak = new boolean[n +1];
        isWordBreak[n]=true;
        for (int i=n-1; i>= 0; i--){
           for (String word : wordDict){
               if ( (i+word.length()) <= n && isWordBreak[i+word.length()]
                       && s.substring(i, i+word.length()).equals(word)){
                       isWordBreak[i] = true;
                       break;
                   }
               }
           }
        return isWordBreak[0];
    }

    public static void main(String[] args) {
        WordBreak139 prog = new WordBreak139();
        System.out.println(prog.wordBreak("applepenapple", Arrays.asList("apple","pen")));
        System.out.println(prog.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }
}
