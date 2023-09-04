package hashmap;

import java.util.*;

public class RepeatedDNASequence187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 10) return result;
        Map<String, Integer> seen = new HashMap<>();
        String pattern;
        for (int i=9; i <s.length();i++){
            pattern = s.substring(i-9, i+1);
            seen.merge(pattern, 1, Integer::sum);
            if (seen.get(pattern) == 2)
                result.add(pattern);
        }
        return result;
    }

    public static void main(String[] args) {
        RepeatedDNASequence187 prog = new RepeatedDNASequence187();
        System.out.println(prog.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(prog.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }
}
