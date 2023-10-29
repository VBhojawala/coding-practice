package arrays.string;

public class NumberOfValidClockTimes2437 {
    public int countTime(String time) {
        int count = 1;

        if (time.charAt(1) == '?'){
            if (time.charAt(0) == '?')
                count *= 24;
            else if (time.charAt(0) == '2')
                count *= 4;
            else
                count *= 10;
        }
        if (time.charAt(0) == '?' && time.charAt(1) != '?'){
            if (time.charAt(1) <= '3')
                count *=3;
            else
                count *=2;
        }

        if (time.charAt(4) == '?')
            count *= 10;
        if (time.charAt(3) == '?')
            count *= 6;

        return count;
    }

    public static void main(String[] args) {
        NumberOfValidClockTimes2437 prog = new NumberOfValidClockTimes2437();
        System.out.println(prog.countTime("??:??"));
        System.out.println(prog.countTime("0?:0?"));
        System.out.println(prog.countTime("?5:00"));
    }
}
