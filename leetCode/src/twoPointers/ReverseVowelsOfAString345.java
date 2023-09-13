package twoPointers;

public class ReverseVowelsOfAString345 {
    public String reverseVowels(String s) {
        boolean[] vowels = new boolean[128];
        for (char c: "aeiouAEIOU".toCharArray())
            vowels[c] = true;

        int left=0 , right =s.length()-1;
        char temp;
        StringBuilder str = new StringBuilder(s);

        while (left < right){
            while (left < right && !vowels[str.charAt(left)])
                left++;
            while (left < right && !vowels[str.charAt(right)])
                right--;

            if (left < right){
                temp = str.charAt(left);
                str.setCharAt(left, str.charAt(right));
                str.setCharAt(right, temp);
                left++; right--;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString345 prog = new ReverseVowelsOfAString345();
        System.out.println(prog.reverseVowels("hello"));
        System.out.println(prog.reverseVowels("leetcode"));
    }
}
