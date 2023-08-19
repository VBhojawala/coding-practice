package greedy;

public class MergeTripletsToTargetTriplet1899 {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        boolean[] isMatch = new boolean[3];

        for (int[] cur: triplets ){
            if (cur[0] > target[0] || cur[1] > target[1] || cur[2] > target[2])
                continue;
            if (cur[0] == target[0])
                isMatch[0] = true;
            if (cur[1] == target[1])
                isMatch[1] = true;
            if (cur[2] == target[2])
                isMatch[2] = true;
        }

        return isMatch[0] && isMatch[1] && isMatch[2];

    }

    public static void main(String[] args) {
        MergeTripletsToTargetTriplet1899 prog = new MergeTripletsToTargetTriplet1899();

        int[][] triplets = new int[][]{{2,5,3},{1,8,4},{1,7,5}};
        int[] target = {2,7,5};

        System.out.println(prog.mergeTriplets(triplets, target));

        triplets= new int[][] {{3,4,5},{4,5,6}};
        target = new int[]{3,2,5};
        System.out.println(prog.mergeTriplets(triplets, target));
    }
}
