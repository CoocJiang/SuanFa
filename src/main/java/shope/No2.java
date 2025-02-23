package shope;

import java.util.Arrays;

public class No2 {
    public static void main(String[] args) {
        System.out.println(pickGoods(new int[]{1500,800,200}, 1600));
    }
    static int [][] dp;
    public static int pickGoods(int[] goods_list, int balance) {
        // write code here
        dp = new int[goods_list.length+1][balance+1];
        for (int i = 0;i<goods_list.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return process(goods_list,0,balance);
    }
    public static int process(int[] goods_list,int index,int k){
        if (k>=0&&dp[index][k]!=-1){
            return dp[index][k];
        }
        if (k<0||index==goods_list.length){
            return 0;
        }else {
            //当前商品选
            int p1 = goods_list[index]+process(goods_list,index+1,k-goods_list[index]);
            int p2 = process(goods_list,index+1,k);
            if (p1>k){
                dp[index][k] = p2<=k ?p2:0;
            }else{
                if (p2<=k){
                    dp[index][k] = Math.max(p1,p2);
                }else {
                    dp[index][k]  =  p1;
                }
            }
            return dp[index][k];
        }
    }
}
