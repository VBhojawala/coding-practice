package twoPointers;

import java.util.Arrays;

public class BoatsToSavePeople881 {
    public int numRescueBoats(int[] people, int limit) {
       int left=0, right= people.length-1, count=0;
       Arrays.sort(people);
       while (left <= right){
           if (people[left] + people[right] <= limit)
               left++;
           right--;
           count++;
       }
        return count;
    }

    public static void main(String[] args) {
        BoatsToSavePeople881 prog = new BoatsToSavePeople881();
        System.out.println(prog.numRescueBoats(new int[]{1,2}, 3));
        System.out.println(prog.numRescueBoats(new int[]{3,2,2,1}, 3));
        System.out.println(prog.numRescueBoats(new int[]{3,5,3,4}, 5));
    }
}
