package twoPointers;

public class IsSubsequence392 {

    public static boolean isSubsequence(String s, String t) {
        int front =0;
        int rear = 0;

        while (front < s.length() && rear < t.length()){
            if(s.charAt(front) == t.charAt(rear)){
                front++;
            }
            rear++;
        }
        return front == s.length();
    }
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";

        System.out.println("Is Subsequence ? : " + isSubsequence(s, t));

    }
}
