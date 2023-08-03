package bitManipulation;

public class AddBinary67 {
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int aPointer = a.length();
        int bPointer = b.length();
        int carry = 0;

        while (aPointer > 0 || bPointer > 0 || carry > 0){
            int aCur = aPointer > 0 ?  a.charAt(--aPointer) == '0' ? 0 : 1 : 0;
            int bCur = bPointer > 0 ? b.charAt(--bPointer) == '0' ? 0: 1 : 0;

            int sum = aCur + bCur + carry;
            carry = sum / 2 ;
            sum = sum % 2;
            result.append(sum);

        }

        return result.reverse().toString();

    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));

    }
}
