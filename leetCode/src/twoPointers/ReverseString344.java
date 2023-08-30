package twoPointers;

import java.util.Arrays;

public class ReverseString344 {
    public void reverseString(char[] s) {
        int left=0, right= s.length-1;
        char temp;
        while (left < right){
            temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseString344 prog = new ReverseString344();
        char[] str = new char[]{'h','e','l','l','o'};
        prog.reverseString(str);
        str = new char[]{'H','a','n','n','a','h'};
        prog.reverseString(str);
    }
}
