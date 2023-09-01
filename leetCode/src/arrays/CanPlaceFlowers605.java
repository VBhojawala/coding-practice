package arrays;

public class CanPlaceFlowers605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n==0) return true;
        if (flowerbed.length == 1){
            if (flowerbed[0] == 0)
                n--;
            return n<=0;
        }
        if (flowerbed[0] == 0 && flowerbed[1] == 0){
            flowerbed[0] =1;
            n--;
        }
        int len = flowerbed.length;
        if (len > 1 && flowerbed[len-1] == 0 && flowerbed[len-2] ==0){
            flowerbed[len-1] =1;
            n--;
        }

        for (int i=1; i<len-1;i++){
            if (flowerbed[i-1] == 0 && flowerbed[i] == 0 && flowerbed[i+1] ==0){
                flowerbed[i++] = 1;
                n--;
            }
        }

        return n <= 0;
    }

    public static void main(String[] args) {
        CanPlaceFlowers605 prog = new CanPlaceFlowers605();
        System.out.println(prog.canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
        System.out.println(prog.canPlaceFlowers(new int[]{1,0,0,0,0}, 3));
    }
}
