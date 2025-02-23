package A_leetcode.leetcodeall;

import java.util.Arrays;
import java.util.Comparator;

public class No3111 {

    public static void main(String[] args) {
        int[][] points = {
                {1,3},
                {7,3}
        };
        System.out.println(minRectanglesToCoverPoints(points, 1));
    }
    public static int minRectanglesToCoverPoints(int[][] points, int w) {
        //首先从矩形的第一个点开始  每个点从开始都取一个矩形并且宽度都选择w 高度可以忽略

        int n = points.length;
        //先按起始点x进行排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int start = points[0][0];
        int ans = 0;
        int i = 0;
        while (start<=points[n-1][0]){
            start += w;
            while (i<n&&points[i][0]<=start){
                i++;
            }
            ans++;
            start = i<n ? points[i][0]:Integer.MAX_VALUE;
        }
        return ans;
    }
}
