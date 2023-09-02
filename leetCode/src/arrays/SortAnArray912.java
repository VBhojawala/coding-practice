package arrays;

public class SortAnArray912 {
    int aux[];
    int nums[];
    public int[] sortArray(int[] nums) {
        this.nums = nums;
        aux = new int[nums.length];
        sort(0, nums.length -1);
        return nums;
    }

    private void sort(int low, int high){
        if(high <= low ) return;
        int mid = low + (high -low ) / 2 ;

        sort(low, mid);
        sort(mid + 1, high);

        merge(low, mid, high);
    }

    private void  merge(int low, int mid, int high){
        for (int k=low; k <= high; k++){
            aux[k] = nums[k];
        }
        int left=low, right= mid +1;
        for (int k= low; k <= high; k++){
            if (left > mid) nums[k] = aux[right++];
            else if (right > high) nums[k] = aux[left++];
            else if (aux[left] < aux[right]) nums[k] = aux[left++];
            else  nums[k] = aux[right++];
        }
    }
}
