package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllTheAnagramsInString438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m= s.length(), n=p.length();

        if (m< n)
            return result;

        int pCount[] = new int[26];
        int sCount[] = new int[26];

        for (int i=0;i<n;i++)
            pCount[p.charAt(i)-'a']++;

        for (int i=0; i<n-1; i++)
            sCount[s.charAt(i)-'a']++;

        for (int i=n-1; i< m; i++){
            sCount[s.charAt(i) - 'a']++;
            if (Arrays.equals(sCount, pCount)){
                result.add(i+1 - n);
            }
            sCount[s.charAt(i+1 -n) - 'a']--;
        }
        return result;
    }

}
