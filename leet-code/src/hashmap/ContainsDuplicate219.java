package hashmap;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i=0; i< nums.length; i++){
            if(window.contains(nums[i])){
                return true;
            }else {
                window.add(nums[i]);
            }
            if (i >= k){
                window.remove(nums[i-k]);
            }
        }

        return false;

    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;

        System.out.println("Contains Duplicate ? : " + containsNearbyDuplicate(nums, k));
    }
}
