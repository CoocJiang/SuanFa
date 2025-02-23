package A_leetcode.leetcodeall;

import java.util.*;

public class No2374 {

    public static void main(String[] args) {
        System.out.println(edgeScore(new int[]{1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
    }
    public static int edgeScore(int[] edges) {
        long [] arr = new long[edges.length];
        long max = 0;
        for (int i = 0;i< edges.length;i++){
            arr[edges[i]]+=i;
            max = Math.max(max,arr[edges[i]]);
        }
        for (int i = 0;i<edges.length;i++){
            if (arr[i]==max){
                return i;
            }
        }
        return 0;
    }
}
