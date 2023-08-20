package graph.general;

import java.util.*;

public class AlienDictionary269 {

    Map<Character,Set<Character>> adj = new HashMap();
    Map<Character, Boolean> visited =new HashMap<>();
    StringBuilder result;
    public String alienOrder(String[] words) {
        for (String word : words){
            for (char c : word.toCharArray()){
               adj.computeIfAbsent(c, a-> new HashSet<>());
            }
        }

        String word1, word2;
        for(int i=0; i< words.length -1; i++){
            word1 = words[i];
            word2 = words[i+1];

            if (word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }

            for (int j=0; j< Math.min(word1.length(), word2.length()); j++){
                if (word1.charAt(j) != word2.charAt(j)){
                    adj.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }

        result = new StringBuilder();
        for (char c : adj.keySet()){
            if (dfs(c))
                return "";
        }

        return result.reverse().toString();
    }

    private boolean dfs(char v){
        if (visited.containsKey(v))
            return visited.get(v);

        visited.put(v, true);

        for (char n : adj.get(v)){
            if (dfs(n))
                return true;
        }

        visited.put(v, false);
        result.append(v);
        return false;
    }

    public static void main(String[] args) {
        AlienDictionary269 prog = new AlienDictionary269();
        System.out.println(prog.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
        System.out.println(prog.alienOrder(new String[]{"z","x"}));
        System.out.println(prog.alienOrder(new String[]{"z","x","z"}));
    }


}
