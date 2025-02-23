package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No1039 {

    static int [][]dp = new int[51][51];
    public static int minScoreTriangulation(int[] values) {
        //构成的所有的三角形中，必然存在values[0]*values[n]*某一条边构成的三角形
        for (int i = 0;i<values.length;i++){
            Arrays.fill(dp[i],-1);
            dp[i][i+1] = 0;
            dp[i][i] = 0;
        }
        return process(values,0,values.length-1);
    }
    public static int process(int[] values,int l,int r){
        if (dp[l][r]!=-1){
            return dp[l][r];
        }
        if (l+1>=r){
            //此时不能构成三角形
            return 0;
        } else if (l+2==r){
            //刚好三个点能够构成三角形
            return dp[l][r]=values[l]*values[l+1]*values[r];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = l+1;i<r;i++){
            //以l和r连成一条线为底边，和其他所有点组成的三角形取最小值
            ans = Math.min(ans,process(values,l,i)+process(values,i,r)+values[i]*values[l]*values[r]);
        }
        return dp[l][r]=ans;
    }
}
