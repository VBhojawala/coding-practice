package arrays;

public class LengthOfLastWord58 {
    public int lengthOfLastWord(String s) {
        int right = s.length()-1;
        while (s.charAt(right) == ' ')
            right--;
        int left=right;
        while (left >= 0 && s.charAt(left) != ' ')
            left--;
        return right-left;
    }

    public static void main(String[] args) {
        LengthOfLastWord58 prog = new LengthOfLastWord58();
        System.out.println(prog.lengthOfLastWord("Hello World"));
        System.out.println(prog.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(prog.lengthOfLastWord("luffy is still joyboy"));
    }
}
