package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No312 {

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
    }

    static int [][]dp = new int[302][302];
    static int [] arr = new int[302];
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        //假设首尾存在气球，但是不能戳爆
        arr[0] = 1;
        arr[n+1] = 1;
        for (int i = 0;i<n;i++){
            arr[1+i] = nums[i];
        }
        //严格位置依赖版本
        for (int i = 1;i < n+1;i++){
            Arrays.fill(dp[i],-1);
            dp[i][i] = arr[i-1]*arr[i+1]*arr[i];
        }
        for (int i = n+1;i>=1;i--){
            for (int j = i+1;j<n+1;j++){
                for (int k = i+1;k<j;k++){
                    // 假设i点的气球是l...r上最后爆的
                    dp[i][j] = Math.max(dp[i][j],dp[i][k-1]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j+1]);
                }
                dp[i][j] = Math.max(dp[i][j] ,dp[i][j-1]+arr[j]*arr[j+1]*arr[i-1]);
                dp[i][j]  = Math.max(dp[i][j] ,dp[i+1][j]+arr[i]*arr[i-1]*arr[j+1]);
            }
        }
        return dp[1][n];
    }

    //求l...r上所能获得硬币的最大数量并且 l-1和r+1是存在气球的。
    public static int process(int[] nums,int l,int r){
        if (dp[l][r]!=-1){
            return dp[l][r];
        }
        if(l==r){
            dp [l][r] = nums[l-1]*nums[l+1]*nums[l];
            return dp [l][r];
        }else {
            int max = 0;
            for (int i = l+1;i<r;i++){
                // 假设i点的气球是l...r上最后爆的
                max = Math.max(max,process(nums,l,i-1)+process(nums,i+1,r)+nums[l-1]*nums[i]*nums[r+1]);
            }
            max = Math.max(max,process(nums,l,r-1)+nums[r]*nums[r+1]*nums[l-1]);
            max = Math.max(max,process(nums,l+1,r)+nums[l]*nums[l-1]*nums[r+1]);
            dp [l][r] = max;
            return max;
        }
    }
}
