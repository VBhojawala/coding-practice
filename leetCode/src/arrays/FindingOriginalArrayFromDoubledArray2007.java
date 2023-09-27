package arrays;

public class FindingOriginalArrayFromDoubledArray2007 {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length, max=0;
        if (n % 2 == 1) return new int[0];

        for (int num : changed)
            max = Math.max(max, num);

        int[] count = new int[max*2 +1];

        for (int num : changed)
            count[num]++;

        int[] result = new int[n/2];
        int pos = 0, d=0;

        for(int i=0; i<=max; i++){
            if (count[i] >0){
                count[i]--;
                d = i *2;
                if (count[d] > 0){
                    result[pos++] = i;
                    count[d]--;
                    i--;
                }else {
                    return new int[0];
                }
            }
        }
        return result;
    }
}
