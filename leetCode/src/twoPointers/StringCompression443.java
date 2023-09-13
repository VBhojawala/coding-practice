package twoPointers;

import java.util.Arrays;

public class StringCompression443 {
    public int compress(char[] chars) {
        int pos =0, n = chars.length;
        for (int i=0, j=i+1; i< n;){
            while (j< n && chars[i] == chars[j])
                j++;
            chars[pos++] = chars[i];
            if (j-i > 1){
                String len = String.valueOf(j-i);
                for (char c : len.toCharArray())
                    chars[pos++] = c;
            }
            i = j;
        }
        return pos;
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        StringCompression443 prog = new StringCompression443();
        System.out.println(prog.compress(chars));
    }
}
