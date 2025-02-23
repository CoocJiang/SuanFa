package wuba;

import java.util.Arrays;
import java.util.HashMap;

public class No3 {

    public static void main(String[] args) {
        System.out.println(numberOfWays(1, 2, 3));
    }
    static int mod = 1000000007;
    static int [][]dp;
    public static int numberOfWays (int startPos, int endPos, int k) {
        // write code here
        int length = Math.abs(endPos-startPos);
        if (length>k){
            return 0;
        } else if (length==k) {
            return 1;
        }else {
            int mink = k;
           dp = new int[k+1][3001];
           for (int i = 0;i<=k;i++){
               Arrays.fill(dp[i],-1);
           }
            return  process(startPos,endPos,k);
        }
    }

    private static int process(int index, int endPos, int k) {
        if (dp[k][index+1000]!=-1){
            return dp[k][index+1000];
        }
        int length = Math.abs(endPos-index);
        if (length>k){
            return 0;
        } else if (length==k)  {
            return 1;
        }else {
            //往左
            int p1 = process(index-1,endPos,k-1);
            //往右
            int p2 = process(index+1,endPos,k-1);

            long ans = p2+p1;
            dp[k][index+1000] = (int) (ans%mod);
            return dp[k][index+1000] ;
        }
    }
}
