package hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        result.add(list1); result.add(list2);

        for (int num : set1){
            if (!set2.contains(num))
                list1.add(num);
        }

        for (int num : set2){
            if (!set1.contains(num))
                list2.add(num);
        }

        return result;

    }
}
