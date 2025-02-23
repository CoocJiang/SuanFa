package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No399 {



    public double[] calcEquation(List<List<String>> equations, double[] values,
                                 List<List<String>> queries) {

        Unifind unifind = new Unifind(queries.size()*2);
        //每个字母映射为一个数字，因为我们在并查集中使用数字处理会更容易
        HashMap<String,Integer> map = new HashMap<>();
        String a = null;
        String b = null;
        int id = 0;
        for (int i=0;i<equations.size();i++){
           a= equations.get(i).get(0);
           b =equations.get(i).get(1);

           if (!map.containsKey(a)){
               map.put(a,id);
               id++;
           }
            if (!map.containsKey(b)){
                map.put(b,id);
                id++;
            }
            unifind.union(map.get(a),map.get(b),values[i]);
        }
        double [] ans = new double[queries.size()];
        for (int i=0;i<queries.size();i++){
            a= queries.get(i).get(0);
            b =queries.get(i).get(1);
            ans[i]= unifind.isconected(map.get(a), map.get(b));
        }
            return ans;
    }


    public static class Unifind{
        int [] parent;
        double [] weight;


        //初始化并查集
        public Unifind(int size){
            parent = new int[size];
            weight = new double[size];
            for (int i=0;i<size;i++){
                parent [i] = i;
                weight [i] = 1.0d;
            }
        }
        //路径压缩算法
        public void union(int x,int y,double value){
            //查找x节点的根节点和y的根节点
            int rootx =  find(x);
            int rooty = find(y);
            if (rooty!=rootx){
                parent[rootx] = rooty ;
                weight[rootx] = weight[y] * value /weight[x];
            }else {
                return;
            }
        }
        public int find(int x) {
           if (x!=parent[x]){
               //说明当前不是根节点
               int origin = parent[x];
               parent[x] = find(parent[x]);
               weight[x] = weight[x]*weight[origin];
           }
           return parent[x];
        }

        public double isconected(int a,int b){
            int roota = find(a);
            int roob = find(b);
            if (roob==roota){
                return weight[a]/weight[b];
            }else {
                return -1d;
            }
        }

    }
}
