package slidingWindow;

public class MinimumNumberOfFlipsToMakeBinaryStringAlternating1888 {
    public int minFlips(String s) {
        int n = s.length(), diff =0;
        String target = "01";

        for (int i=0;i<n;i++){
            if (s.charAt(i) != target.charAt(i&1))
                diff++;
        }

        int result = Math.min(diff, n-diff);

        for (int i=0;i<n;i++){
            if (s.charAt(i) != target.charAt(i&1))
                diff--;
            if (s.charAt(i) != target.charAt((i+n) & 1))
                diff++;
            result = Math.min(result, Math.min(diff, n-diff));
        }

        return result;

    }

    public static void main(String[] args) {
        MinimumNumberOfFlipsToMakeBinaryStringAlternating1888 prog = new MinimumNumberOfFlipsToMakeBinaryStringAlternating1888();
        System.out.println(prog.minFlips("111000"));
        System.out.println(prog.minFlips("010"));
        System.out.println(prog.minFlips("1110"));
    }
}
