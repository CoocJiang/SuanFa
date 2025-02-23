package A_leetcode.leetcodeall;

import java.util.HashSet;

public class No494 {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
    static int count ;
    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        count = 0;
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }
        // p = 正数和
        // t = 负数和
        //sum - p = t
        //target = p-t = p-(sum - p);
        //p = (sum+target)/2
        if((sum+target)%2==1||sum<target){
            return 0;
        }
        int  p = (sum+target)/2;

        return process(nums,p);
    }
    public static int process(int []nums,int p){
        int n = nums.length;
//        int [][] dp = new int[n+1][p+1];
//        dp[0][0] = 1;
//        for (int row = 1;row<=n;row++){
//            for (int col = 0;col<=p;col++){
//                dp[row][col] = dp[row-1][col];
//                if ((col-nums[row-1])>=0){
//                    dp[row][col]+=dp[row-1][col-nums[row-1]];
//                }
//            }
//        }`

        int [] dp = new int[p+1];
        dp[0] = 1;
        for (int i = 1;i<=n;i++){
            for (int j = p;j>=0;j--){
                if (j>=nums[i-1]){
                    dp[j]+=dp[j-nums[i-1]];
                }
            }
        }
        return dp[p];
    }
}
