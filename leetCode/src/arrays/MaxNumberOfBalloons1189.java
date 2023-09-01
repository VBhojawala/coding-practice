package arrays;

public class MaxNumberOfBalloons1189 {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        int result=Integer.MAX_VALUE;

        for (int i=0; i<text.length(); i++)
            count[text.charAt(i)-'a']++;

        count['o'-'a'] /=2;
        count['l'-'a'] /=2;

        for (char c : "balon".toCharArray())
            result = Math.min(result, count[c-'a']);

        return result;
    }

    public static void main(String[] args) {

    }
}
