package arrays.string;

public class FindUniqueBinaryString1980 {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder result = new StringBuilder();
        for (int i=0; i< nums.length; i++){
            char ch = nums[i].charAt(i);
            result.append(ch == '0' ? '1' : '0');
        }
        return result.toString();
    }
}
