package A_leetcode.leetcodeall;

import jdk.nashorn.internal.ir.SplitReturn;

import java.util.*;

public class No56 {
    public static void main(String[] args) {
        merge(new int[][]{{1,4},{4,5}});
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
       list.add(intervals[0]);
        for (int i = 1;i<intervals.length;i++){
            int [] cur = list.get(list.size()-1);
            if (cur[1]>intervals[i][0]){
                list.remove(list.size()-1);
                list.add(process(cur,intervals[i]));
            }else {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
    public static int[] process(int [] a,int []b) {
        int max = Math.max(a[1],b[1]);
        int min = Math.min(a[0],b[0]);
        return new int[]{min,max};
    }
}
