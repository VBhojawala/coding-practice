package slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfVowelsInSubstring1456 {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');vowels.add('e');vowels.add('i');
        vowels.add('o'); vowels.add('u');

        int total =0, max=0;
        for (int i=0; i<k;i++){
            if (vowels.contains(s.charAt(i)))
                total++;
        }

        max = total;

        for (int i=k;i<s.length();i++){
            if (vowels.contains(s.charAt(i)))
                total++;
            if (vowels.contains(s.charAt(i-k)))
                total--;
            max = Math.max(max, total);
        }

        return max;
    }

}
