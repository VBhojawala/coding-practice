package twoPointers;

public class ValidPalindromeII680 {

    String s;
    public boolean validPalindrome(String s) {
        this.s = s;
        int left =0, right = s.length()-1;

        while (left<right){
            if (s.charAt(left) != s.charAt(right))
                return isPalindrome(left+1, right) || isPalindrome(left, right-1);
            left++; right--;
        }
        return true;
    }

    private boolean isPalindrome(int left, int right){
        while (left<right){
            if (s.charAt(left)!=s.charAt(right))
                return false;
            left++; right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII680 prog = new ValidPalindromeII680();
        System.out.println(prog.validPalindrome("aba"));
        System.out.println(prog.validPalindrome("abca"));
        System.out.println(prog.validPalindrome("abc"));
    }
}
