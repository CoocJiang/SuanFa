package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No1135 {

    public static void main(String[] args) {
        System.out.println(minimumCost(3, new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}}));
    }
    public static int minimumCost(int n, int[][] connections) {
        Unifind unifind = new Unifind(n+1);
        Arrays.sort(connections,((o1, o2) -> o1[2]-o2[2]));
        int ans = 0;
        for (int i = 0;i<connections.length&& unifind.count>1;i++){
            if (!unifind.issame(connections[i][0],connections[i][1])){
                unifind.union(connections[i][0],connections[i][1]);
                ans+=connections[i][2];
            }
        }
        return unifind.count==1 ? ans:-1;
    }

    public static class Unifind{

        int [] size;
        int [] f;

        int count;
        public Unifind(int n) {
            f = new int[n];
            size = new int[n];
            for (int i = 0;i<n;i++){
                f[i] = i;
                size[i] =1;
            }
            count = n-1;
        }

        public int getf(int i){
            if (f[i]!=i){
                f[i] = getf(f[i]);
            }
            return f[i];
        }


        public void union(int a,int b){
            int fa = getf(a);
            int fb = getf(b);
            if (size[fa]>size[fb]){
                f[fb] = fa;
                size[fa]+=size[fb];
            }else {
                f[fa] = fb;
                size[fb]+=size[fa];
            }
            count--;
        }

        public boolean issame(int a,int b){
            return getf(a)==getf(b);
        }
    }
}
