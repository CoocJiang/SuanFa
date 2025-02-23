package A_leetcode.leetcodeall;

import java.util.Arrays;
import java.util.Map;

public class No879 {

    public static void main(String[] args) {
        System.out.println(profitableSchemes(10, 5, new int[]{2,3,5}, new int[]{6,7,8}));
    }

    public static int mod = 1000000007;
    static long [][][] dp ;
    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp = new long[minProfit+1][n+1][profit.length];
        for (int i = 0;i<minProfit+1;i++){
            for (int j = 0;j<n+1;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return process(minProfit,group,profit,n,0);
    }
    private static int process(int minProfit, int[] group, int[] profit, int rest, int i) {
        //如果目标达成，返回1种
        if(i==group.length){
            return minProfit==0 ? 1:0 ;
        }
        if (dp[minProfit][rest][i]!=-1){
            return (int)dp[minProfit][rest][i];
        }
        //当前做或者不做
        long ans = process(minProfit,group,profit,rest,i+1)%mod;
        int newrest = rest-group[i];
        if (newrest>=0){
            ans=(ans+process(Math.max(minProfit-profit[i],0),group,profit,newrest,i+1))%mod;
        }
        dp[minProfit][rest][i] = ans;
        return (int) ans%mod;
    }
}
