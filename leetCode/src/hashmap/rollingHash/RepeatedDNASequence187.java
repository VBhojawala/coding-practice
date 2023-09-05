package hashmap.rollingHash;

import java.util.*;
import java.util.stream.Collectors;

public class RepeatedDNASequence187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 10) return result;
        Set<Integer> visited= new HashSet<>();
        Set<Integer> repeat = new HashSet<>();
        int hash = 0, mask = (1 << 27 ) - 1;

        for (int i=0;i<9;i++)
            hash = (hash << 3) | getVal(s.charAt(i));

        for (int i=9;i<s.length();i++){
            hash = (hash << 3) | getVal(s.charAt(i));
            if (!visited.add(hash))
                repeat.add(hash);
            hash &= mask;
        }

        return repeat.stream().map(String::valueOf).collect(Collectors.toList());
    }

    private int getVal(char c){
        if (c == 'A') return 1;
        if (c == 'C') return 2;
        if (c == 'G') return 3;
        if (c == 'T') return 4;
        return 0;
    }


    public static void main(String[] args) {
        RepeatedDNASequence187 prog = new RepeatedDNASequence187();
        System.out.println(prog.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(prog.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }
}
