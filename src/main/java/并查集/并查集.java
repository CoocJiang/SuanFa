package 并查集;

import java.util.HashMap;

public class 并查集 {

    public  class unifind{

        int [] farther;
        int [] size;
        //用来扁平化的辅助数组
//        int [] stack;
        public unifind(int s){
            farther = new int [s+1];
            size = new int [s+1];
//            stack = new int [s+1];
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
//            // 沿途收集了几个点
//            int size = 0;
            while (i != farther[i]) {
                farther[i] = find(farther[i]);
//                stack[size++] = i;
//                i = farther[i];
            }
            // 沿途节点收集好了，i已经跳到代表节点了
//            while (size > 0) {
//                farther[stack[--size]] = i;
//            }
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
