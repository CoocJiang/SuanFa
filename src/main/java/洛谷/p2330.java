package 洛谷;

import java.io.BufferedReader;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


public class p2330 {

    public static class unifind{
        int [] farther;
        int [] size;
        //用来扁平化的辅助数组
        int [] stack;
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

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int [][] edges = new int[m][3];
        unifind unifind = new unifind(m);

        for (int i=0;i<m;i++){
            s = bf.readLine().split(" ");
            edges[i][0] = Integer.parseInt(s[0]);
            edges[i][1] = Integer.parseInt(s[1]);
            edges[i][2] = Integer.parseInt(s[2]);
        }
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        int size = 1;
        int max = 0;
        for (int []edge:edges){
            if (unifind.find(edge[0])!=unifind.find(edge[1])){
                size++;
                max= edge[2];
                unifind.union(edge[0],edge[1]);
                if (size==n){
                    break;
                }
            }
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.print(size-1);
        out.print(" ");
        out.print(max);
        out.flush();
        out.close();
    }

}
