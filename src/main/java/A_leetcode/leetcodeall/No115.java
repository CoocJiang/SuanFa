package A_leetcode.leetcodeall;


import java.util.Arrays;

public class No115 {
    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }
//    static int[][] dp  ;
//
//    public static int numDistinct(String s, String t) {
//        //定义转移方程 dp[i][j]表示 在到s[i]位置之前所有的子序列满足t的前j（不包含j）个字符的数量
//        char[] chars = s.toCharArray();
//        char[] chars1 = t.toCharArray();
//        int n = chars.length;
//        int m = t.length();
//        dp = new int[n+1][m+1];
//        //当 j = 0的时候，默认空串是不是就能解决
//        for (int i = 0;i<n+1;i++){
//            dp[i][0] = 1;
//        }
//        //当前 i j位置，分两种情况，如果 s字符串i位置的字符等于t字符串j位置的字符
//        //dp[i][j] = dp[i-1][j-1]+dp[i-1][j]
//        //如果不等于dp[i][j] = dp[i-1][j]
//        for (int i = 1;i<n+1;i++){
//            for (int j = 1;j<=i&&j<m+1;j++){
//                dp[i][j]+=dp[i-1][j];
//                if (chars1[j-1]==chars[i-1]){
//                    dp[i][j] += dp[i-1][j-1];
//                }
//            }
//        }
//        return dp[n][m];
//    }


    static int mod = 1000000007;
    static int [][] dp;
    public static int numDistinct(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        dp = new int[chars1.length][chars2.length];
        for (int i = 0;i<chars1.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return process(chars1,chars2,0,0);
    }

    private static int process(char[] chars1, char[] chars2, int i, int j) {
        if (chars2.length==j){
            return 1;
        }else if(i==chars1.length){
            return 0;
        } else{
            if (dp[i][j]!=-1){
                return dp[i][j];
            }
            long ans = 0;
            if (chars1[i]==chars2[j]){
                ans += process(chars1,chars2,i+1,j+1);
            }
            ans += process(chars1,chars2,i+1,j)%mod;
            dp[i][j] =  (int) ans;
            return  dp[i][j];
        }
    }


}
