package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No474 {
    public static void main(String[] args) {
        String[] arr = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(arr, 5, 3));
    }
    static int [][][] dp;
    public static int findMaxForm(String[] strs, int m, int n) {
        //来到index位置，两种情况 要或者不要
        dp = new int[n+1][m+1][strs.length];
        for (int i = 0;i<n+1;i++){
            for (int j = 0;j<m+1;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return process(strs,m,n,0);
    }

    public static int process(String[] strs, int m, int n,int index){
        if(index==strs.length){
            return 0;
        }
        //来到index位置，两种情况 要或者不要
        if(dp[n][m][index]!=-1){
            return dp[n][m][index];
        }
        int p1 = process(strs,m,n,index+1);
        int ncnt = 0;
        int mcnt = 0;
        for(int i = 0;i<strs[index].length();i++){
            if(strs[index].charAt(i)=='1'){
                ncnt++;
            }
        }
        mcnt = strs[index].length()-ncnt;
        int p2 = 0;
        if(n-ncnt>=0&&m-mcnt>=0){
            p2 = process(strs,m-mcnt,n-ncnt,index+1)+1;
        }
        dp[n][m][index] = Math.max(p1,p2);
        return dp[n][m][index];
    }
}
