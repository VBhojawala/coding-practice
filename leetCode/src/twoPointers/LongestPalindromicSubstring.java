package twoPointers;

public class LongestPalindromicSubstring {

    int n;
    String s;
    public String longestPalindrome(String s) {
        this.s = s;
        n = s.length();
        int start = 0, max = 1;
        for (int i = 0; i < n; ++i) {
            int a = match(i, i);
            int b = match(i, i + 1);
            int length = Math.max(a, b);
            if (max < length) {
                max = length;
                start = i - ((length - 1) >> 1);
            }
        }
        return s.substring(start, start + max);
    }

    private int match(int left, int right){
        while (left >=0 && right < n && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left -1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring prog = new LongestPalindromicSubstring();
        System.out.println(prog.longestPalindrome("babad"));
    }
}
