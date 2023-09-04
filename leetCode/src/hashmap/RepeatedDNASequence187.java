package hashmap;

import java.util.*;

public class RepeatedDNASequence187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 10) return result;
        Map<String, Integer> seen = new HashMap<>();

        for (int i=9; i <s.length();i++)
            seen.merge(s.substring(i-9, i+1), 1, Integer::sum);

        for ( Map.Entry<String , Integer> e: seen.entrySet()){
            if (e.getValue() > 1)
                result.add(e.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        RepeatedDNASequence187 prog = new RepeatedDNASequence187();
        System.out.println(prog.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(prog.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }
}
