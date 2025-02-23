package A_leetcode.Leetcode.msb算法.并查集;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 并查集数组形式实现岛问题 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //可变岛屿
        int[][] grid = new int[5][5];
        int [][]position = new int[][]{{1,0},{1,0},{3,0},{0,1}};
        UnionFind uf= new UnionFind(grid);
        List<Integer> list =new ArrayList<>();
        for (int [] a:position){
            list.add(connect(a[0],a[1],grid,uf));
        }
        System.out.println(list);
    }
    public static int island(int[][] board){

        UnionFind uf= new UnionFind(board);
        for (int j=1;j<board[0].length-1;j++){
            if (board[0][j-1]==1&&board[0][j]==1){
                union(uf,0,j-1,0,j,board);
            }
        }
        for (int i=1;i<board.length;i++){
            if (board[i][0]==1&&board[i-1][0]==1){
                union(uf,i,0,i-1,0,board);
            }
        }
        for (int i=1;i<board.length;i++){
            for (int j=1;j<board[0].length-1;j++){
                if (board[i][j]==1&&board[i][j+1]==1){
                    union(uf,i,j,i,j+1,board);
                }
                if (board[i][j]==1&&board[i-1][j]==1){
                    union(uf,i,j,i-1,j,board);
                }
            }
        }
        return uf.sets;
    }

    public static class UnionFind{
        int[] parent;
        int [] size;
        int [] help;
        int sets;
        public UnionFind(int [][]board){
            int row = board.length;
            int cul = board[0].length;
            this.parent = new int[cul*row];
            this.size = new int[cul*row];
            this.help = new int[cul*row];
//              区域数量
            this.sets = 0;
            for (int i=0;i<row;i++){
               for(int j=0;j<cul;j++){
                   if (board[i][j] == 1) {
                       this.size[i] = 1;
                       int index = index(i,j,board);
                       //存下i的父亲，默认为自己
                       this.parent[index]=index;
                       //每个节点的大
                       sets++;
                   }
               }
            }
        }
    }
    public static int index(int i,int j,int[][]board){
        return i*board[0].length+j;
    }
    public static void union(UnionFind unionFind, int r,int c,int a, int b,int board[][]){
        if (r > board.length || c > board[0].length|| a < 0 || b < 0 ||r< 0 || c < 0||a > board.length || b > board[0].length) {
            return;
        }
        int m=  index(r,c,board);
        int n=  index(a,b,board);
        int f1 = find(unionFind ,m);
        int f2 = find(unionFind,n);
        if (f1 == f2){
            return;
        }else if(unionFind.size[f1]>unionFind.size[f2]){
            unionFind.parent[f2] = f1;
            unionFind.size[f2] = unionFind.size[f1]+unionFind.size[f2];
        }else  {
            unionFind.parent[f1] = f2;
            unionFind.size[f1] = unionFind.size[f1]+unionFind.size[f2];
        }
        unionFind.sets--;
    }
    public static int find(UnionFind unionFind, int a){
        int hi = 0;
        while (unionFind.parent[a]!=a){
            unionFind.help[hi] = a;
            hi++;
            a = unionFind.parent[a];
        }
        for (hi--;hi>=0;hi--){
            unionFind.parent[unionFind.help[hi]]=a;
        }
        return a;
    }

    public static int connect(int r,int c,int [][]board,UnionFind uf){
        int s= index(r,c,board);
        if (uf.size[s]==1){
            return uf.sets;
        }else {
            uf.size[s]=1;
            uf.sets++;
            union(uf,r,c,r-1,c,board);
            union(uf,r,c,r,c+1,board);
            union(uf,r,c,r,c-1,board);
            union(uf,r,c,r+1,c,board);
        }
        return uf.sets;
    }
}
