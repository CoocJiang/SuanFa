package A_leetcode.leetcodeall;

import A_leetcode.面试150.No399;

import java.util.Arrays;
import java.util.Comparator;

public class No1168 {
    //村里面一共有 n 栋房子。我们希望通过建造水井和铺设管道来为所有房子供水。
    //对于每个房子 i，我们有两种可选的供水方案：一种是直接在房子内建造水井，成本为 wells[i - 1] （注意 -1 ，因为 索引从0开始 ）；
    // 另一种是从另一口井铺设管道引水，数组 pipes 给出了在房子间铺设管道的成本，
    // 其中每个 pipes[j] = [house1j, house2j, costj] 代表用管道将 house1j 和 house2j连接在一起的成本。连接是双向的。
    public static void main(String[] args) {
        System.out.println(minCostToSupplyWater(3, new int[]{1, 2, 2}, new int[][]{{1, 2, 1}, {2, 3, 1}}));
    }
    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int well = 0;
        int [][] edges = new int[n+ pipes.length][3];
        int i=0;
        for (;i<pipes.length;i++){
            edges[i][0] = pipes[i][0];
            edges[i][1] = pipes[i][1];
            edges[i][2] = pipes[i][2];
        }
        for (int j=0;j<wells.length;j++,i++){
            edges[i][0] = well;
            edges[i][1] = j+1;
            edges[i][2] = wells[j];
        }
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        int count = 0;
        int size = 1;
        unifind unifind = new unifind(n);
        for (int[] edge:edges){
            //如果不在一个并查集内
            if (unifind.find(edge[0])!=unifind.find(edge[1])){
                size++;
                count+=edge[2];
                unifind.union(edge[0],edge[1]);
                if (size==n+1){
                    break;
                }
            }
        }
        return count;
    }


    public static class unifind{

        static int [] farther;
        static int [] size;
        //用来扁平化的辅助数组
        static int [] stack;
        public unifind(int s){
            farther = new int [s+1];
            size = new int [s+1];
            stack = new int [s+1];
            for (int i = 0;i<=s;i++){
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


        public static int find(int i) {
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
        public static int findfarther(int a){
            if (farther[a]!=a){
                farther[a] = findfarther(farther[a]);
            }
            return farther[a];
        }

        public static void union(int a, int b){
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
