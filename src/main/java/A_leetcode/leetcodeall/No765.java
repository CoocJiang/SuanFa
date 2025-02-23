package A_leetcode.leetcodeall;

import java.util.HashSet;

public class No765 {


        static int [] farther = new int [31];
         static int [] stack = new int [31];
        static int set;

        static int n=0;

        public static boolean issameset(int a,int b){
            if ( findfarther(a)==findfarther(b)){
                return true;
            }
            return false;
        }


    public static int findfarther(int a){
        if (farther[a]!=a){
            farther[a] = findfarther(farther[a]);
        }
        return farther[a];
    }


        public static void union(int a,int b){
            int f1 = findfarther(a);
            int f2 = findfarther(b);
            if (f1!=f2){
                farther[f1] = f2;
                set--;
            }
        }


    public static int minSwapsCouples(int[] row) {
            set = row.length/2;
            for (int i=0;i<row.length/2;i++){
                farther[i] = i;
            }
        for(int i=0;i<row.length;i=i+2){
            if (row[i]/2!=row[i+1]/2){
                union(row[i]/2,row[i+1]/2);
            }
        }
        return row.length/2 -set;
    }

        public static void main(String[] args) {
            System.out.println(minSwapsCouples(new int[]{5,4,2,6,3,1,0,7}));
        }
}
