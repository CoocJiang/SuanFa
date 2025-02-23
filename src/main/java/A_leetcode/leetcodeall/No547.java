package A_leetcode.leetcodeall;

import A_leetcode.面试150.No399;

import java.util.Arrays;
import java.util.Stack;

public class No547 {

    public static class Unifind{
        int [] parent;

        int allsize ;
        //初始化并查集
        public Unifind(int size){
            parent = new int[size];
            allsize = size;
            for (int i=0;i<size;i++){
                parent [i] = i;
            }
        }
        //路径压缩算法
        public void union(int x,int y){
            //查找x节点的根节点和y的根节点
            int rootx =  find(x);
            int rooty = find(y);
            if (rooty!=rootx){
                parent[rootx] = rooty ;
                allsize--;
            }else {
                return;
            }
        }
        public int find(int x) {
            if (x!=parent[x]){
                //说明当前不是根节点
                int origin = parent[x];
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean isconected(int a,int b){
            int roota = find(a);
            int roob = find(b);
            if (roob==roota){
                return true;
            }else {
                return false;
            }
        }

    }


    public static int findCircleNum1(int[][] isConnected) {
        Unifind unifind = new Unifind(isConnected.length);
        int n = isConnected.length;
        for (int i = 0;i<n;i++){
            for (int j = 0;j<isConnected[i].length;j++){
                if(isConnected[i][j]==1&&!unifind.isconected(i,j)){
                    unifind.union(i,j);
                }
            }
        }
        return unifind.allsize;
    }




    static boolean visited[] = new boolean[200];
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Arrays.fill(visited,false);
        int provice  = 0;
        for (int i = 0;i<n;i++){
            if (!visited[i]){
                visited[i]=true;
                dfs(i,isConnected,visited);
                provice++;
            }
        }
        return provice;
    }

    public static void dfs(int num,int[][] isConnected,boolean[] visited){
        for (int i = 0;i<isConnected[num].length;i++){
            if (isConnected[num][i]==1&&!visited[i]){
                   visited[i]=true;
                   dfs(i,isConnected,visited);
            }
        }
    }

    public static void main(String[] args) {
        int [][] arr = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(arr));
    }
}
