package bitManipulation;

public class MinimumNumberOfFlipsToMakeaOrbEqualsToC1318 {
    public int minFlips(int a, int b, int c) {
        int count =0, x, y, z;
        for (int i=0; i< 30; i++){
            x = a >> i & 1;
            y = b >> i & 1;
            z = c >> i & 1;
            if ((x | y) != z)
                count += x == 1 && y == 1 ? 2 : 1;
        }
        return count;
    }
}
