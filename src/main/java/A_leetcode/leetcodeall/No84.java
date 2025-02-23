package A_leetcode.leetcodeall;

import java.util.Random;

public class No84 {
    public static void main(String[] args) {
        int [] h = {1,2,3,4,5};
        System.out.println(largestRectangleArea(h));
    }


    public static int largestRectangleArea1(int[] heights) {
        int [][] ans = new int[heights.length][2];
        int r =0;
        int max = 0;
        ans[heights.length-1][1] = heights.length;
        ans[0][0] = -1;
        r++;
        for (int i=1;i<heights.length;i++){
            ans[i][0] = stack[r-1];
            //当此时的数小于栈里的数时，就一直弹出
            while (r>0&&heights[i]<heights[stack[r-1]]){
                ans[i][0] = ans[stack[r-1]][0];
                ans[stack[r-1]][1]=i;
                max = Math.max(max,heights[stack[r-1]]*(ans[stack[r-1]][1]-ans[stack[r-1]][0]-1));
                r--;
            }
            stack[r++] = i;
        }
        max = Math.max(heights[stack[r-1]]*(ans[stack[r-1]][1]-ans[stack[r-1]][0]-1),max);
        r--;
        while (r>0){
            ans[stack[r-1]][1] = ans[stack[r]][1];
            max = Math.max(max,heights[stack[r-1]]*(ans[stack[r-1]][1]-ans[stack[r-1]][0]-1));
            r--;
        }
        return max;
    }


    public static int [] stack = new int [100000];
    public static int [][] ans = new int[100000][2];
    public static int largestRectangleArea(int[] heights) {
        int r = 0;
        int result = 0;
        for (int i = 0;i<heights.length;i++){
            while (r>0&&heights[stack[r-1]]>=heights[i]){
                int cur = stack[--r];
                ans[cur][0] = r>0 ? stack[r-1]:-1;
                ans[cur][1] = i;
            }
            stack[r++] = i;
        }
        while (r>0){
            int cur = stack[--r];
            ans[cur][0] = r>0 ? stack[r-1]:-1;
            ans[cur][1] = heights.length;
        }
        for (int i = heights.length-2;i>=0;i--){
            if (ans[i][1]<heights.length&&heights[ans[i][1]] == heights[i]){
                ans[i][1] = ans[ans[i][1]][1];
            }
        }
        for (int i = 0;i<heights.length;i++){
            result = Math.max(result,heights[i]*(ans[i][1]-ans[i][0]-1));
        }
        return result;
    }
}
