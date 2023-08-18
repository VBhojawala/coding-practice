package arrays;

import java.util.Arrays;

public class Candy135 {
    public int candy(int[] ratings) {
        int n = ratings.length, total=0;
        int left[] = new int[n];
        int right[] = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i=1; i<n; i++){
            if (ratings[i] > ratings[i-1])
                left[i] = left[i-1] + 1;
        }

        for (int j=n-2; j >=0; j-- ){
            if(ratings[j] > ratings[j+1]){
                right[j] = right[j+1] + 1;
            }
        }

        for (int i=0; i < n; i++){
            total += Math.max(left[i], right[i]);
        }

        return total;

    }

    public static void main(String[] args) {
        Candy135 prog = new Candy135();
        System.out.println(prog.candy(new int[]{1,0,2}));
        System.out.println(prog.candy(new int[]{1,2,2}));
    }
}
