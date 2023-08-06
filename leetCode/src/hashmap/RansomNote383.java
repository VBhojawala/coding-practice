package hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote383 {

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        for(int i=0; i < magazine.length(); i++){

            if(!magazineMap.containsKey(magazine.charAt(i))){
                magazineMap.put(magazine.charAt(i), 1);
            }
            else {
                magazineMap.computeIfPresent(magazine.charAt(i),(k,v) -> {return v+1;});
            }

        }

        for(int j=0; j < ransomNote.length(); j++){
            if(!magazineMap.containsKey(ransomNote.charAt(j))){
                return false;
            }
            else if(magazineMap.get(ransomNote.charAt(j)) > 1){
                magazineMap.computeIfPresent(ransomNote.charAt(j),(k,v) -> {return v-1;});
            }
            else {
                magazineMap.remove(ransomNote.charAt(j));
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String ransomNote = "a", magazine = "b";
        System.out.println("Contains all Letters ? : " + canConstruct(ransomNote, magazine));
    }
}
