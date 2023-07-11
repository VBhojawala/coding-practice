package arrays;

public class SortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;

        while(i >= 0 && j>=0 ){
            if(nums1[i] > nums2[j]){
                nums1[i+j+1] = nums1[i--];
            }else{
                nums1[i+j+1] = nums2[j--];
            }
        }

        while(j >=0){
            nums1[j] = nums2[j--];
        }

    }

    public static void main(String[] args) {
        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {2,5,6};

        merge(nums1, 3, nums2, 3);
        for (int i=0;i < nums1.length;i++){
            System.out.print(nums1[i] +", ");
        }

    }
}
