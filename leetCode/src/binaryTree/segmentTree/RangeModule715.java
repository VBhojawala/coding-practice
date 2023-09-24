package binaryTree.segmentTree;

public class RangeModule715 {

    SegmentTree tree ;
    public RangeModule715() {
        tree = new SegmentTree(0, (int)1e9, false);
    }

    public void addRange(int left, int right) {
        tree.update(left, right, true);
    }

    public boolean queryRange(int left, int right) {
        return tree.query(left, right);
    }

    public void removeRange(int left, int right) {
        tree.update(left, right, false);
    }

    class SegmentTree{
        int low, high;
        SegmentTree left, right;
        boolean isIncluded;

        public SegmentTree(int low, int high, boolean isIncluded) {
            this.low = low;
            this.high = high;
            this.isIncluded = isIncluded;
        }

        public boolean update(int lo, int hi, boolean include) {
            // CASE 1 : Complete Overlap
            if(lo <= low && hi >= high) {
                isIncluded = include;
                left = null;
                right = null;
                return isIncluded;
            }

            // CASE 2 : No Overlap
            if(low >= hi || high <= lo) return isIncluded;

            //  CASE 3 : Partial Overlap
            int mid = low + (high - low) / 2;
            if(left == null) {
                left = new SegmentTree(low, mid, isIncluded);
                right = new SegmentTree(mid, high, isIncluded);
            }

            boolean leftIncluded = left.update(lo, hi, include);
            boolean rightIncluded = right.update(lo, hi, include);
            isIncluded = leftIncluded & rightIncluded;

            return isIncluded;
        }

        public boolean query(int lo, int hi) {
            // CASE 1 : Complete Overlap
            if(low >= lo && high < hi) return isIncluded;

            // CASE 2 : No Overlap
            if(low >= hi || high <= lo) return true;

            //CASE 3 : Partial Overlap
            boolean leftQuery = (left == null) ? isIncluded : left.query(lo, hi);
            boolean rightQuery = (right == null) ? isIncluded : right.query(lo, hi);

            return leftQuery && rightQuery;
        }
    }

    public static void main(String[] args) {
        RangeModule715 prog = new RangeModule715();
        prog.addRange(10, 20);
        prog.removeRange(14,16);
        System.out.println(prog.queryRange(10,14));
        System.out.println(prog.queryRange(13,15));
        System.out.println(prog.queryRange(16,17));
    }

}
