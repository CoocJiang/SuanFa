package mt;

import java.util.*;

public class No56 {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        merge(intervals);
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
//        Deque<int[]> stack = new ArrayDeque<>();
        int [][]stack = new int[intervals.length][2];
        int r = 0;
        stack[r++] = intervals[0];
        for (int i = 1;i<intervals.length;i++){
            if (r>0&&stack[r-1][1]>=intervals[i][0]){
                int [] pop = stack[--r];
                stack[r++] = (new int[]{pop[0],Math.max(pop[1],intervals[i][1])});
            }else {
                stack[r++]=intervals[i];
            }
        }
        int [][] ans  =  new int[r][2];
        int index= 0 ;
        while (r>0){
            ans[index++] = stack[--r];
        }
        return ans;
    }
}
