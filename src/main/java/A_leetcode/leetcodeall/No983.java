package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No983 {
    public static void main(String[] args) {
        System.out.println(mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
    }

    static int [] day = new int[]{1,7,30};

    static int [] dp = new int [366];
    public static int mincostTickets(int[] days, int[] costs) {
        Arrays.fill(dp,0);
        dp[days.length-1] = Integer.MAX_VALUE;
        for (int i :costs){
            dp[days.length-1] = Math.min(i,dp[days.length-1]);
        }
        for (int i = days.length-2;i>=0;i--){
            int cost = Integer.MAX_VALUE;
            //来到当前i位置，i位置有三种选择，每一种都选，返回最小的那个
            for (int j = 0;j<costs.length;j++){
                int index = i;
                int cur = days[index]+day[j];
                while (index<days.length&&days[index]<cur){
                    index++;
                }
                cost = Math.min(costs[j]+dp[index],cost);
            }
            dp[i] = cost;
        }
        return dp[0];
    }

//    private static int process(int[] days, int[] costs, int i) {
//        if (i >= days.length){
//            return 0;
//        }
//        if (dp[i]!=-1){
//            return dp[i];
//        }
//        int cost = Integer.MAX_VALUE;
//        //来到当前i位置，i位置有三种选择，每一种都选，返回最小的那个
//        for (int j = 0;j<costs.length;j++){
//            int index = i;
//            int cur = days[index]+day[j];
//            while (index<days.length&&days[index]<cur){
//                index++;
//            }
//            cost = Math.min(costs[j]+process(days,costs,index),cost);
//        }
//        dp[i] = cost;
//        return cost;
//    }
}
