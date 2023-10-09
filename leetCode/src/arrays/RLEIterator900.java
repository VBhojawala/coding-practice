package arrays;

public class RLEIterator900 {
    private int[] encoding;
    private int curr, i;
    public RLEIterator900(int[] encoding) {
        this.encoding = encoding;
        curr = 0; i = 0;
    }

    public int next(int n) {
        while (i<encoding.length){
            if (curr + n > encoding[i]){
                n -= encoding[i] -curr;
                i += 2;
                curr = 0;
            }else {
                curr += n;
                return encoding[i+1];
            }
        }
        return -1;
    }

}
