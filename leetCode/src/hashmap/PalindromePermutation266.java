package hashmap;

public class PalindromePermutation266 {
    public boolean canPermutePalindrome(String s) {
        int[] charCount = new int[26];
        for (char ch : s.toCharArray()){
            charCount[ch-'a']++;
        }
        int count =0;

        for (int i=0; i< 26; i++){
            count += charCount[i] % 2;
        }

        return count <= 1;

    }
}
