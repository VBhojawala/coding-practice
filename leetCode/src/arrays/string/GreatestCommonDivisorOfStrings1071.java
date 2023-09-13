package arrays.string;

public class GreatestCommonDivisorOfStrings1071 {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1+str2).equals(str2+str1))
            return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b){
        if (b == 0) return a;
        return gcd(b, a% b);
    }

    public static void main(String[] args) {
        String str1 = "ABCABC", str2 = "ABC";
        GreatestCommonDivisorOfStrings1071 prog = new GreatestCommonDivisorOfStrings1071();
        System.out.println(prog.gcdOfStrings(str1, str2));
        str1 = "ABABAB"; str2 = "ABAB";
        System.out.println(prog.gcdOfStrings(str1, str2));
    }
}
