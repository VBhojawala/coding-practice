package arrays;

public class ZigZagConversion6 {
    public String convert(String s, int numRows) {
        int n= s.length(), incr = 2 * (numRows -1);
        if ( numRows == 1) return s;

        StringBuilder result  = new StringBuilder();
        for (int r=0; r<numRows; r++){
            for (int i=r; i <n; i+= incr){
                result.append(s.charAt(i));
                if (r > 0 && r < numRows-1 && i+ incr - (2*r) < n )
                    result.append(s.charAt( i+ incr - (2*r)));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion6 prog = new ZigZagConversion6();
        System.out.println(prog.convert("PAYPALISHIRING", 3));
    }
}
