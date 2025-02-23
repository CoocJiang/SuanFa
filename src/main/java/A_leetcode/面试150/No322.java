package A_leetcode.面试150;

public class No322 {
//    给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//    计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
//    你可以认为每种硬币的数量是无限的。
    public static void main(String[] args) {
        int [] coins = {2};
        System.out.println(coinChange2(coins,3));
    }

    static class nums{
        Integer count;
    }
    public static int coinChange(int[] coins, int amount) {
        if (coins==null){
            return -1;
        }
        long ans = pro(0,coins,amount);
        if (ans==Integer.MAX_VALUE){
            return -1;
        }
        return (int)ans ;
    }
    public static long pro(int index,int[] coins,int rest){
        //basecase
        if (index==coins.length){
           if (rest==0){
               return 0;
           }else {
               return Integer.MAX_VALUE;
           }
        }
        //当前位置，
        long count =Integer.MAX_VALUE;
        long ans = 0;
        for (int i=0;i*coins[index]<=rest;i++){
            ans = pro(index+1,coins,rest-i*coins[index]);
            if (ans != Integer.MAX_VALUE) {
                ans = i + ans;
                count = Math.min(ans, count);
            }else {
                continue;
            }
        }
        return count;
    }
    //动态规划优化
    public static int coinChange2(int[] coins, int amount){
        int [][] dp = new int[coins.length+1][amount+1];
        for (int rest=1;rest<=amount;rest++){
            dp[coins.length][rest] = Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for (int index =coins.length-1;index>=0;index--){
            for (int rest = 1;rest<=amount;rest++){
                int count =Integer.MAX_VALUE;
                int ans =0;
                for (int i=0;i*coins[index]<=rest;i++){
                    ans = dp[index+1][rest-i*coins[index]];
                    if (ans != Integer.MAX_VALUE) {
                        ans = i + ans;
                        count = Math.min(ans, count);
                    }else {
                        continue;
                    }
                }
                dp[index][rest]=  count;
                min = Math.min(dp[index][rest],min);
            }
        }
        return dp[0][amount]==Integer.MAX_VALUE ? -1:dp[0][amount];
    }
}
