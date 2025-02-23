package A_leetcode.leetcodeall;

import java.util.Arrays;
import java.util.Comparator;

public class No1697 {
    public static void main(String[] args) {
       for (boolean i: distanceLimitedPathsExist(5,new int[][]{{0,1,10},{1,2,5},{2,3,9},{3,4,13}},new int[][]{{0,4,14},{1,4,13}})){
           System.out.println(i);
       };
    }

    public static boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        Arrays.sort(edgeList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        boolean [] ans= new boolean[queries.length];
        int [][]querieses = new int[queries.length][4];
        for (int i=0;i<queries.length;i++){
            querieses[i][0] = queries[i][0];
            querieses[i][1] = queries[i][1];
            querieses[i][2] = queries[i][2];
            querieses[i][3] = i;
        }
        Arrays.sort(querieses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        unifind unifind = new unifind(n);
        int j = 0;
        for (int i=0;i< querieses.length;i++){
            while (j<edgeList.length&&edgeList[j][2]<querieses[i][2]){
                if (unifind.find(edgeList[j][0])!=unifind.find(edgeList[j][1])){
                    unifind.union(edgeList[j][0],edgeList[j][1]);
                }
                j++;
            }
            if (unifind.find(querieses[i][0])==unifind.find(querieses[i][1])){
                ans[querieses[i][3]] = true;
            }
        }
        return ans;
    }


    public static class unifind{

        int [] farther;
        int [] size;
        //用来扁平化的辅助数组
        int [] stack;
        public unifind(int s){
            farther = new int [s];
            size = new int [s];
            stack = new int [s];
            for (int i = 0;i<s;i++){
                farther[i] = i;
                size[i] = 1;
            }
        }

        public boolean issameset(int a,int b){
            if ( findfarther(a)==findfarther(b)){
                return true;
            }
            return false;
        }


        public  int find(int i) {
            // 沿途收集了几个点
            int size = 0;
            while (i != farther[i]) {
                stack[size++] = i;
                i = farther[i];
            }
            // 沿途节点收集好了，i已经跳到代表节点了
            while (size > 0) {
                farther[stack[--size]] = i;
            }
            return i;
        }

        //不适用辅助数组使用递归也可以实现
        public int findfarther(int a){
            if (farther[a]!=a){
                farther[a] = findfarther(farther[a]);
            }
            return farther[a];
        }

        public void union(int a,int b){
            int f1 = findfarther(a);
            int f2 = findfarther(b);
            if (f1!=f2){
                if (size[f1]>size[f2]){
                    farther[f2] = f1;
                    size[f1]+=size[f2];
                }else {
                    farther[f1] = f2;
                    size[f2]+=size[f1];
                }
            }
        }
    }
}
