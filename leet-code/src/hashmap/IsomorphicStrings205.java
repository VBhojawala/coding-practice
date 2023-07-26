package hashmap;

import java.util.HashMap;
import java.util.Map;
public class IsomorphicStrings205 {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i=0; i < s.length(); i++){
           Character s1 = s.charAt(i);
           Character t1 = t.charAt(i);
           if((sMap.containsKey(s1) && sMap.get(s1) != t1) || (tMap.containsKey(t1) && tMap.get(t1) != s1)){
               return false;
           }
           sMap.put(s1, t1);
           tMap.put(t1, s1);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println("Is Isomorphic ? : " + isIsomorphic(s, t));
    }
}
