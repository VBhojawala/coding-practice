package bitManipulation;

public class AddTwoIntegers2235 {
    public int sum(int num1, int num2) {
        int carry;
        while (num2 != 0){
            carry = (num1 & num2) << 1;
            num1 ^= num2;
            num2 = carry;
        }
        return num1;
    }
}
