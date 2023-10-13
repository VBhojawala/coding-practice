package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LargestTimeForGivenDigits949 {
    private boolean[] visited = new boolean[4];
    private int[] arr;
    private List<Integer> temp = new ArrayList<>();

    private int max;
    public String largestTimeFromDigits(int[] arr) {
        this.arr = arr; max = -1;
        dfs(0);
        if (max == -1 ) return "";
        else return String.format("%02d:%02d", max / 60, max % 60);
    }

    private void dfs(int len){
        if (len == 4){
            compare();
            return;
        }

        for (int i=0;i<4; i++){
            if (!visited[i]){
                visited[i] = true;
                temp.add(arr[i]);
                dfs(len+1);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    private void compare(){
        int hour = temp.get(0) * 10 + temp.get(1);
        int minutes = temp.get(2) * 10 + temp.get(3);

        if (hour < 24 && minutes < 60)
            max = Math.max(max, hour * 60 + minutes);

    }

    public static void main(String[] args) {
        LargestTimeForGivenDigits949 prog = new LargestTimeForGivenDigits949();
        System.out.println(prog.largestTimeFromDigits(new int[]{1,2,3,4}));
        System.out.println(prog.largestTimeFromDigits(new int[]{5,5,5,4}));
    }
}
