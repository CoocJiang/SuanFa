package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No3176 {
    public static void main(String[] args) {
        System.out.println(maximumLength(new int[]{29,30,30},0));
    }

    static int kp;
    static int [][][] dp;
    public static int maximumLength(int[] nums, int k) {
        kp =  k;
        int n = nums.length;
        dp = new int[n][n][k+1];
        for (int i = 0;i< n;i++){
            for (int j = 0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return process(0,0,nums,0);
    }

    private static int process(int index1,int index2,int[] nums,int now) {

        if (index1== nums.length){
            return 0;
        }else {
            if (dp[index1][index2][now] != -1){
                return dp[index1][index2][now];
            }
            //当前位置要或者不要
            int p1 = 0;
            int p2 = 0;
            //要
            if (index2<1||nums[index1]==nums[index2-1]){
                p1 = 1+process(index1+1,index1+1,nums,now);
            }else if (now<kp){
                p1 = 1+process(index1+1,index1+1,nums,now+1);
            }
            //不要
            p2 = process(index1+1,index2,nums,now);
            dp[index1][index2][now] = Math.max(p1,p2);
            return dp[index1][index2][now];
        }
    }


    public static int qunaertest3(String s){
        int []arr = new int[10];
        char[] chars = s.toCharArray();
        for (int i = 0;i<chars.length;i++){
            arr[chars[i]-'0']++;
        }
        int ans =  0;
        for (int i:arr){
            ans+=i/2;
        }
        return ans;
    }
}
