package arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class NamingACompany2306 {
    public long distinctNames(String[] ideas) {
        Set<String> ideaSet = Arrays.stream(ideas).collect(Collectors.toSet());
        int[][] freq = new int[26][26];
        int prefix;

        for (String s : ideas){
            char[] idea = s.toCharArray();
            prefix = idea[0] -'a';
            for (int i=0;i<26;i++){
                idea[0] = (char) (i+'a');
                if (!ideaSet.contains(String.valueOf(idea))){
                    freq[prefix][i]++;
                }
            }
        }

        long count=0;

        for (String s : ideas){
            char[] idea = s.toCharArray();
            prefix = idea[0] -'a';
            for (int i=0;i<26;i++){
                idea[0] = (char) (i+'a');
                if (!ideaSet.contains(String.valueOf(idea))){
                    count += freq[i][prefix];
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {
        NamingACompany2306 prog = new NamingACompany2306();
        System.out.println(prog.distinctNames(new String[]{"coffee","donuts","time","toffee"}));
    }
}
