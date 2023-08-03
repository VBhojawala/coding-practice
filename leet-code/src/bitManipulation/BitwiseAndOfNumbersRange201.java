package bitManipulation;

public class BitwiseAndOfNumbersRange201 {
    public static int rangeBitwiseAnd(int left, int right) {
        int shiftCount=0;
        while (left !=right){
            left >>= 1;
            right >>= 1;
            shiftCount++;
        }
        return left << shiftCount;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5,7));
        System.out.println(rangeBitwiseAnd(1, 2147483647));
    }
}
