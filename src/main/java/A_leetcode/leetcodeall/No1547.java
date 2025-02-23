package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No1547 {

    public static void main(String[] args) {
        System.out.println(minCost(7, new int[]{3, 5, 1, 4}));
    }

    static int [][] dp = new int[102][102];
    public static int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int ans = Integer.MAX_VALUE;
        int length = cuts.length;
        int [] arr = new int[length+2];
        arr[length+1] = n;
        for (int i = 0;i<cuts.length;i++){
            arr[i+1] = cuts[i];
        }
        int l = 0;
        int r = length+1;
        for (int i = 0;i<r;i++){
            Arrays.fill(dp[i],-1);
        }

        for (int i = 1;i<cuts.length+1;i++){
            ans = process(arr,l,r);
        }
        return ans;
    }


    public static int process(int[] arr,int l,int r){
        if (dp[l][r]!=-1){
            return dp[l][r];
        }
        if (r-1==l){
            return 0;
        }else {
            int ans = Integer.MAX_VALUE;
            for (int i = l+1;i<r;i++){
                ans = Math.min(process(arr,l,i)+process(arr,i,r)+arr[r]-arr[l],ans);
            }
            dp[l][r] = ans;
            return ans;
        }
    }
}
