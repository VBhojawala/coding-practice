package arrays.string;

public class PerformStringShifts1427 {
    public String stringShift(String s, int[][] shift) {
        int totalShift = 0;
        for(int[] entry: shift){
            if (entry[0] == 1)
                totalShift += entry[1];
            else
                totalShift -= entry[1];
        }

        int n = s.length();
        totalShift = (totalShift % n + n) % n;

        return  s.substring(n - totalShift) + s.substring(0, n - totalShift);
    }

    public static void main(String[] args) {
        int[][] shifts = new int[][] {{1,1},{1,1},{0,2},{1,3}};
        String s = "abcdefg";

        PerformStringShifts1427 prog = new PerformStringShifts1427();
        System.out.println(prog.stringShift(s, shifts));
    }
}
