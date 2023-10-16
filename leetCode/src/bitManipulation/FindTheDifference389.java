package bitManipulation;

public class FindTheDifference389 {
    public char findTheDifference(String s, String t) {
        char ch =0;

        for (char c : s.toCharArray())
            ch ^= c;

        for (char c : t.toCharArray())
            ch ^= c;

        return ch;
    }
}
