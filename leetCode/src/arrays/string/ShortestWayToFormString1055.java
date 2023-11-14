package arrays.string;

public class ShortestWayToFormString1055 {
    public int shortestWay(String source, String target) {
        int m = source.length(), n= target.length();
        int j=0, count = 0;
        while (j <n){
            int i =0;
            boolean isOk = false;
            while (i <m && j<n){
                if (source.charAt(i) == target.charAt(j)){
                    isOk = true;
                    j++;
                }
               i++;
            }
            if (!isOk)
                return -1;
            count++;

        }
        return count;
    }

    public static void main(String[] args) {
        ShortestWayToFormString1055 prog = new ShortestWayToFormString1055();
        System.out.println(prog.shortestWay("abc", "abcbc"));
        System.out.println(prog.shortestWay("abc", "acdbc"));
    }
}
