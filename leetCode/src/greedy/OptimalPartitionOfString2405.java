package greedy;

public class OptimalPartitionOfString2405 {
    public int partitionString(String s) {
        int bitMap =0, count =1, index;

        for (char c : s.toCharArray()){
            index = c - 'a';
            if (((bitMap >> index) & 1) == 1){
                bitMap=0;
                count++;
            }
            bitMap = bitMap | (1 << index);
        }

        return count;
    }

    public static void main(String[] args) {
        OptimalPartitionOfString2405 prog = new OptimalPartitionOfString2405();
        System.out.println(prog.partitionString("abacaba"));
        System.out.println(prog.partitionString("ssssss"));
    }
}
