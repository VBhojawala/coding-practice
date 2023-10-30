package twoPointers;

public class FlippingAnImage832 {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] row : image){
            int left = 0, right = row.length -1;
            for ( ; left < right; left++, right--){
                if (row[left] == row[right]){
                    row[left] ^= 1;
                    row[right] ^= 1;
                }
            }
            if (left == right)
                row[left] ^= 1;
        }
        return image;
    }
}
