package twoPointers;

public class PushDominoes838 {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length() +2;
        char[] dom = new char[n];
        dom[0] = 'L';
        dom[n-1] = 'R';

        for (int i=1; i< n-1; i++)
            dom[i] = dominoes.charAt(i-1);

        int left=0, right=0;

        while (++right < n){
            left = right - 1;
            while (dom[right] == '.')
                right++;

            if ((dom[left] == 'L' && dom[right] == 'L')  || (dom[left] == 'R' && dom[right] == 'R')){
                while (++left <= right)
                    dom[left] = dom[right];
            }else if(dom[left] == 'R' && dom[right] == 'L'){
                int tl = left+1, tr = right-1;
                while (tl < tr){
                    dom[tl++] = 'R';
                    dom[tr--] = 'L';
                }
            }
        }
        return String.valueOf(dom,1, n-2);
    }

    public static void main(String[] args) {
        PushDominoes838 prog = new PushDominoes838();
        System.out.println(prog.pushDominoes(".L.R...LR..L.."));
    }
}
