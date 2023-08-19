package greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763 {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex  = new int[26];
        List<Integer> result = new ArrayList<>();

        for (int i=0 ;i <s.length(); i++)
            lastIndex[s.charAt(i)- 'a'] = i;

        int curr=0, prev=0;
        for (int i=0; i<s.length();i++){
            curr = Math.max(curr, lastIndex[s.charAt(i)-'a']);
            if (curr == i){
                result.add(curr-prev+1);
                prev= curr+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PartitionLabels763 prog = new PartitionLabels763();
        System.out.println(prog.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(prog.partitionLabels("eccbbbbdec"));
    }
}
