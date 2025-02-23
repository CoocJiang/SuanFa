package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No1143 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
    static int[][] dp;
    public static int longestCommonSubsequence(String text1, String text2) {
        char [] s1 = text1.toCharArray();
        char [] s2 = text2.toCharArray();
        int n = s1.length;
        int m = s2.length;
        int [][]dp = new int[n+1][m+1];
        if (s1[0]==s2[0]){
            dp[0][0]=1;
        }
        for (int i = 1;i<n;i++){
            if (s1[i]==s2[0]){
                dp[i][0]=1;
            }else {
                dp[i][0]=dp[i-1][0];
            }
        }
        for (int i = 1;i<m;i++){
            if (s2[i]==s1[0]){
                dp[0][i]=1;
            }else {
                dp[0][i]=dp[0][i-1];
            }
        }
        for (int row = 1;row<n;row++){
            for (int col = 1;col<m;col++){
                int p1 = dp[row-1][col-1];
                int p2 = 0;
                int p3 = 0;
                if(s1[row]==s2[col]){
                    p1 += 1;
                }else {
                    p2 = dp[row-1][col];
                    p3 = dp[row][col-1];
                }
                dp[row][col] = Math.max(p1,Math.max(p2,p3));
            }
        }
        return dp[n-1][m-1];
    }


    //返回s1和s2从0..到n和0..m匹配的最长串
    public static int process(char [] s1,char [] s2,int n,int m){
        if(n<0||m<0){
            return 0;
        }else if(dp[n][m]!=-1){
            return dp[n][m];
        }
        //如果 s1[n] = s1[m]
        int p1 = 0;
        int p2 = 0;
        if(s1[n]==s2[m]){
            p1 = process(s1,s2,n-1,m-1)+1;
        }else{
            p1 = process(s1,s2,n,m-1);
            p2 = process(s1,s2,n-1,m);
        }
        dp[n][m] = Math.max(p1,p2);
        return dp[n][m];
    }
}
