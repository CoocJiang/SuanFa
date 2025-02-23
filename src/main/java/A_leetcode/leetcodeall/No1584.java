package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class No1584 {

    public static void main(String[] args) {
        System.out.println(minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}));
    }
    public static int minCostConnectPoints(int[][] points) {
        int nums = points.length;
        //表示i 到 j的距离
        int [][] distances = new int[nums][nums];
        int  distance = 0;
        List<int []> list = new ArrayList<>();
        for (int i = 0;i<nums;i++){
            int startx = points[i][0];
            int starty = points[i][1];
            for (int j = i+1;j<nums;j++){
                if (distances[i][j]==0){
                    distance = Math.abs(points[j][0]-startx)+Math.abs(points[j][1]-starty);
                    distances[i][j] = distance;
                    list.add(new int[]{i,j,distance});
                }
            }
        }
        Unifind unifind = new Unifind(nums);
        list.sort((o1,o2)-> o1[2]-o2[2]);
        int ans = 0;
        for (int [] cur:list){
            if (unifind.count>0){
                if (!unifind.issame(cur[0],cur[1])){
                    unifind.union(cur[0],cur[1]);
                    ans+=cur[2];
                }
            }else {
                break;
            }
        }
        return ans;
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
            count = n;
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
