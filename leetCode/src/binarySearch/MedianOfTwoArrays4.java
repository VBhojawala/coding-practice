package binarySearch;

public class MedianOfTwoArrays4 {

    static int[] nums1;
    static int[] nums2;
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        MedianOfTwoArrays4.nums1 = nums1;
        MedianOfTwoArrays4.nums2 = nums2;

        int median1 = findMedian(0,0, (nums1.length + nums2.length + 1) / 2);
        int median2 = findMedian(0,0,(nums1.length + nums2.length + 2) / 2);

        return (median1 + median2 ) / 2.0;
    }

    private static int findMedian(int nums1P, int nums2P, int noOfElements){

        if (nums1P >= nums1.length)
            return nums2[nums2P + noOfElements -1];
        if (nums2P >= nums2.length)
            return nums1[nums1P + noOfElements -1];
        if (noOfElements == 1)
            return  Math.min(nums1[nums1P], nums2[nums2P]);

        int halfElements = noOfElements / 2;

        int curNum1 = nums1P + halfElements -1 < nums1.length ?  nums1[nums1P + halfElements -1] : Integer.MAX_VALUE;
        int curNum2 = nums2P + halfElements -1 < nums2.length ? nums2[nums2P + halfElements -1] : Integer.MAX_VALUE;

        return curNum1 < curNum2 ? findMedian(nums1P + halfElements, nums2P, noOfElements - halfElements) :
                findMedian(nums1P, nums2P + halfElements, noOfElements - halfElements);

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        System.out.println(findMedianSortedArrays(nums1, nums2));

        nums1 = new int[]{1, 3};
        nums2 = new int[]{2};

        System.out.println(findMedianSortedArrays(nums1, nums2));


    }
}
