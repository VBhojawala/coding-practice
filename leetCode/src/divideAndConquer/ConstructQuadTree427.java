package divideAndConquer;

public class ConstructQuadTree427 {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    int[][] grid;
    public Node construct(int[][] grid) {
        this.grid = grid;
        return dfs(grid.length, 0, 0);
    }

    public Node dfs(int n, int r, int c){
        boolean isLeaf = true;

        for (int i=0; i < n; i++){
            for (int j=0; j < n; j++){
                if (grid[r][c] != grid[r+i][c+j]){
                    isLeaf=false;
                    break;
                }
            }
        }

        if (isLeaf)
            return new Node(grid[r][c] == 1 ? true : false, isLeaf);

        n = n/2;

        Node topLeft = dfs(n, r, c);
        Node topRight = dfs(n, r, c+n);
        Node bottomLeft = dfs(n, r+n, c);
        Node bottomRight = dfs(n, r+n, c+n);

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);

    }
}
