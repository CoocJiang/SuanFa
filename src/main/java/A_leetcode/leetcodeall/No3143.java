package A_leetcode.leetcodeall;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class No3143 {
    public static void main(String[] args) {
        int[][] points = {{-1, -4}, {16, -8}, {13, -3}, {-12, 0}};

        // Define the string s
        String s = "abda";

        System.out.println(maxPointsInsideSquare(points, s));
    }
    static int [][] map = new int[26][2];
    public static int maxPointsInsideSquare(int[][] points, String s) {
        char[] chars = s.toCharArray();
        for (int i = 0;i<26;i++){
           map[i][0] = Integer.MAX_VALUE;
           map[i][1] = Integer.MAX_VALUE;
        }
        //遍历字符串，得到字符串相同字符最大与最小的坐标记录
        for (int i = 0;i<chars.length;i++){
            int cur = chars[i] - 'a';
            //记录坐标中最小的那个
            int point = Math.max(Math.abs(points[i][0]),Math.abs(points[i][1]));
            if (point<=map[cur][0]){
                swap(map[cur],0,1);
                map[cur][0] = point;
            }else if (point<map[cur][1]){
                map[cur][1] = point;
            }
        }
        int min=Integer.MAX_VALUE;
        for (int i=0;i<26;i++){
            if (map[i][1]!=Integer.MAX_VALUE){
                //说明有两个点
                min = Math.min(min,map[i][1]);
            }
        }
        int ans = 0;
        for (int i = 0;i<points.length;i++){
            if (Math.abs(points[i][0])<min&&Math.abs(points[i][1])<min){
                ans++;
            }
        }
        return ans;
    }
    public static void swap(int [] map,int i,int j){
        int num = map[i];
        map[i] = map[j];
        map[j] = num;
    }
}
