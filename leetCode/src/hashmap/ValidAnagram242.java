package hashmap;

public class ValidAnagram242 {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int wordCount[] = new int[26];

        for(int i=0; i<s.length(); i++){
            wordCount[s.charAt(i) - 'a']++;
            wordCount[t.charAt(i) -'a']--;
        }

        for(int i=0;i<26;i++){
            if(wordCount[i] != 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "rat", t = "car";
        System.out.println("Is Anagram : " + isAnagram(s, t));
    }
}
