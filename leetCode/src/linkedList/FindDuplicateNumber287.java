package linkedList;

public class FindDuplicateNumber287 {
    public int findDuplicate(int[] nums) {
       int slow=0, fast=0;

       while (true){
           slow = nums[slow];
           fast = nums[nums[fast]];

           if (slow == fast)
               break;
       }

       fast =0;

       while (true){
           fast = nums[fast];
           slow = nums[slow];

           if (fast == slow)
               return slow;

       }

    }
}
