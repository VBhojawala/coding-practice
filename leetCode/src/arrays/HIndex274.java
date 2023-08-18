package arrays;

public class HIndex274 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n +1];

        for (int i=0; i < n; i++){
            count[Math.min(citations[i], n)]++;
        }

        int c =0;

        for (int h=n; h>0; h--){
            c += count[h];
            if (c >= h)
                return h;
        }

        return 0;
    }

    public static void main(String[] args) {
        HIndex274 prog = new HIndex274();
        System.out.println(prog.hIndex(new int[]{1,3,1}));
    }
}
