package stack.monotonic;

import java.util.Arrays;

public class CarFleet853 {
    public int carFleet(int target, int[] position, int[] speed) {
        Integer [] ids = new Integer[position.length];

        for (int i=0;i<position.length;i++)
            ids[i] =i;

        Arrays.sort(ids, (x,y)-> position[y] - position[x]);

        double time, prev = 0;
        int ans=0;
        for (int i : ids){
            time = 1.0 * ( target - position[i]) / speed[i];
            if (time > prev){
                ans++;
                prev =time;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CarFleet853 prog = new CarFleet853();

        int[] position = new int[]{10,8,0,5,3};
        int[] speed = new int[]{2,4,1,1,3};

        System.out.println(prog.carFleet(12, position, speed));

        position = new int[]{0,2,4};
        speed = new int[]{4,2,1};

        System.out.println(prog.carFleet(100, position, speed));

    }
}
