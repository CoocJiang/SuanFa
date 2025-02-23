package A_leetcode.Leetcode.msb算法.并查集;

public class leetcode并查集应用547题 {
    public static void main(String[] args) {
        int [][] nums = intnit();
        int N = nums.length;
        UnionFind unionFind = new UnionFind(N);
        for (int i = 0;i<nums.length;i++){
            for (int j = i+1;j<nums.length;j++){
                if (nums[i][j]==1){
                    union(unionFind,i,j);
                }
            }
        }
        System.out.println(unionFind.sets);
    }
    public static int [][]intnit(){
        int [][] num= new int[][]{{0,1,1,1},{0,0,1,1},{0,0,0,1},{0,0,0,0}};
        return num;
    }

    public static class UnionFind{
        int[] parent;
        int [] size;
        int [] help;
        int sets;
        public UnionFind(int N){
            this.parent = new int[N];
            this.size = new int[N];
            this.help = new int[N];
//              区域数量
            this.sets = N;
            for (int i=0;i<N;i++){
                //存下i的父亲，默认为自己
                this.parent[i]=i;
//                每个节点的大小
                this.size[i] = 1;
            }
        }
    }
    public static void union(UnionFind unionFind,int a,int b){
        int f1 = find(unionFind ,a);
        int f2 = find(unionFind,b);
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

    public static int find(UnionFind unionFind,int a){
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
}
