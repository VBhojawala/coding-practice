package dynamicProgramming.oneDimensional;

public class PalindromicSubStrings647 {
    public int countSubstrings(String s) {
        int n=s.length(), count=0;
        int left, right;
        for (int i=0;i<n*2-1;i++){
                left = i / 2; right = (i+1) / 2;
                while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                    right++; left--; count++;
                }
        }
        return count;
    }

    public static void main(String[] args) {
        PalindromicSubStrings647 prog = new PalindromicSubStrings647();
        System.out.println(prog.countSubstrings("abc"));
//        System.out.println(prog.countSubstrings("aaa"));
    }
}
