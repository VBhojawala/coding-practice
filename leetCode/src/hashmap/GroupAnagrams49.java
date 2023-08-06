package hashmap;

import java.util.*;

public class GroupAnagrams49 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String ,List<String>> result = new HashMap<>();

        for(int i=0; i< strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedString = String.valueOf(chars);

            result.computeIfAbsent(sortedString, k -> {return  new ArrayList<>();}).add(strs[i]);
        }

        return new ArrayList<>(result.values());
    }
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println("Anagrams : " + groupAnagrams(strs));
    }
}
