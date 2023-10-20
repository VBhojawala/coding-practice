package arrays;

public class IntersectionOfTwoArrays349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] set1 = new boolean[1001];
        for (int num : nums1)
            set1[num] = true;

        boolean[] intersectionSet = new boolean[1001];
        int count=0;

        for (int num: nums2){
            if (set1[num]){
                intersectionSet[num] = true;
                set1[num] = false;
                count++;
            }
        }

        int[] result = new int[count];
        int resultIndex = 0;
        for (int i=0; i<1001; i++){
            if (intersectionSet[i])
                result[resultIndex++] = i;
        }

        return result;
    }
}
