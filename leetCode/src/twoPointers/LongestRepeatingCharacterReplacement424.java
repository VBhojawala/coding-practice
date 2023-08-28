package twoPointers;

public class LongestRepeatingCharacterReplacement424 {
    public int characterReplacement(String s, int k) {
        int maxFreq=0, left=0, right=0;
        int[] count = new int[26];

        for (;right<s.length();right++){
            char curr = s.charAt(right);
            count[curr - 'A']++;

            maxFreq = Math.max(maxFreq, count[curr -'A']);

            if ((right - left + 1) - maxFreq > k)
                --count[s.charAt(left++) - 'A'];
        }
        return right -left;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement424 prog = new LongestRepeatingCharacterReplacement424();
        System.out.println(prog.characterReplacement("ABAB", 2));
        System.out.println(prog.characterReplacement("AABABBA", 1));
        System.out.println(prog.characterReplacement("ABCDEFGHI", 1));
    }
}
