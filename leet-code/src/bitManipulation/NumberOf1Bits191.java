package bitManipulation;

public class NumberOf1Bits191 {
    public int hammingWeight(int n) {
        int result = 0;
        while (n !=0 ){
            result++;
            n &= n-1;
        }
        return result;
    }
}
