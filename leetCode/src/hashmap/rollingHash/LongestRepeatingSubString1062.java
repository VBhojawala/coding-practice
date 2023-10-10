package hashmap.rollingHash;

import java.util.HashSet;

public class LongestRepeatingSubString1062 {

    private String s;
    private HashSet<Long> visited = new HashSet<>();
    private int[] nums;
    private Integer n, a=26;
    private Long hash, aL;
    private final long MODULO = (long) Math.pow(2,24);
    public int longestRepeatingSubstring(String s) {
        this.s = s;
        this.n = s.length();
        nums = new int[n];
        for (int i=0; i<n; i++)
            nums[i] = s.charAt(i) - 'a';

        int left = 1, right = n, len;
        while (left <= right){
            len = left + (right -left) / 2;
            if (search(len) != -1) left = len +1;
            else right = len - 1;
        }
        return left-1;
    }

    private int search(int len){
        hash = 0L;
        for (int i=0; i< len; i++)
            hash = (hash * a + nums[i]) % MODULO;

        visited.clear();
        visited.add(hash);

        aL= 1L;
        for (int i=1; i <= len; i++)
            aL = (aL * a) % MODULO;

        for (int i=1; i< n-len+1; i++){
            hash = (hash * a - nums[i-1] * aL % MODULO + MODULO) % MODULO;
            hash = (hash + nums[i + len -1]) % MODULO;
            if (visited.contains(hash)) return i;
            visited.add(hash);
        }
        return -1;
    }
}
