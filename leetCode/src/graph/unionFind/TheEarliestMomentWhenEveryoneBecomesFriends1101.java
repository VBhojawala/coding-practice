package graph.unionFind;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TheEarliestMomentWhenEveryoneBecomesFriends1101 {

    class UnionFind{
        private int[] cc;
        private int[] size;

        public UnionFind(int n){
            cc = new int[n];
            size = new int[n];

            for (int i=0; i<n; i++){
                cc[i] = i;
                size[i] = i;
            }
        }

        public void union(int a, int b){
            int fa = find(a), fb = find(b);
            if (fa != fb){
                if (size[fa] > size[fb]){
                    cc[fb] = fa;
                    size[fa] += size[fb];
                }else {
                    cc[fa] = fb;
                    size[fb] += size[fa];
                }
            }
        }
        public int find(int x){
            if (cc[x] != x)
                cc[x] = find(cc[x]);
            return cc[x];
        }

    }
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a,b) -> a[0] - b[0]);
        UnionFind uf = new UnionFind(n);
        int t,x,y;
        for (int[] log : logs){
            t = log[0]; x = log[1]; y = log[2];
            if (uf.find(x) != uf.find(y)){
                uf.union(x,y);
                if (--n == 1)
                    return t;
            }
        }
        return -1;
    }
}
