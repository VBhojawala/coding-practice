package arrays.prefixSum;

import java.util.HashSet;
import java.util.Set;

public class UniqueLength3PalindromicSubSequences1930 {
    public int countPalindromicSubsequence(String s) {
        int count=0, left, right;
        Set<Character> cs = new HashSet<>();
        for (char c='a'; c <= 'z'; c++){
            left = s.indexOf(c);
            right = s.lastIndexOf(c);
            cs.clear();

            for (int i=left+1; i < right;i++)
                cs.add(s.charAt(i));

            count+=cs.size();
        }
        return count;
    }

    public static void main(String[] args) {
        UniqueLength3PalindromicSubSequences1930 prog = new UniqueLength3PalindromicSubSequences1930();
        System.out.println(prog.countPalindromicSubsequence("aabca"));
        System.out.println(prog.countPalindromicSubsequence("adc"));
        System.out.println(prog.countPalindromicSubsequence("bbcbaba"));
    }
}
