package A_leetcode.leetcodeall;

import java.util.Arrays;

public class NO1035 {

    public static void main(String[] args) {
        System.out.println(maxUncrossedLines(new int[]{1}, new int[]{1, 3}));
    }
    static int [][] dp = new int[501][501];
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
//        for (int i = 0;i<nums1.length;i++){
//            Arrays.fill(dp[i],0,nums2.length+1,-1);
//        }
        int n = nums1.length;
        int m =nums2.length;
        for (int j = nums2.length;j>=0;j--){
            dp[nums1.length][j] = 0;
        }
        for (int i = nums1.length;i>=0;i--){
            dp[i][nums2.length] = 0;
        }
        for (int i = nums1.length-1;i>=0;i--){
            for (int j = nums2.length-1;j>=0;j--){
                if (nums1[i]==nums2[j]){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
//        return process(nums1,nums2,0,0);
    }
    private static int process(int[] nums1, int[] nums2,int x,int y){
        if (dp[x][y]!=-1){
            return dp[x][y];
        }
        if (x==nums1.length||y==nums2.length){
            return 0;
        }
        //如果x和y能匹配
        if (nums1[x]==nums2[y]){
            dp[x][y] = 1 + process(nums1,nums2,x+1,y+1);
            return dp[x][y];
        }else {
            int p1 = process(nums1,nums2,x,y+1);

            int p2 = process(nums1,nums2,x+1,y);

            dp[x][y] = Math.max(p1,p2);
            return dp[x][y];
        }
    }
}
