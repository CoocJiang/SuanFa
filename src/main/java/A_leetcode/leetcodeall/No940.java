package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No940 {




    static int mod = 1000000007;
    //方法1
    public int distinctSubseqII1(String s) {
        long [] arr = new long [26];  // 用于记录以每个字符结尾的子序列数量
        char [] chars = s.toCharArray();
        long ans = 0;  // 最终答案
        for(int i = 0; i < chars.length; i++){
            long num = (ans + 1)%mod ;  // 以当前字符结尾的子序列总数
            long old  = arr[chars[i] - 'a'];// 上一次以当前字符结尾的子序列的总数
            ans = (ans + num - old + mod) % mod; // 因为现在统计以当前字符结尾的子序列的时候会统计之前的，所以要减去旧值
            //例如：abcc      第三个以c结尾的子序列 abc bc ac c  第四个以c结尾的   abcc abc bc ac c cc 会统计重复的，所以要减去旧的值
            arr[chars[i] - 'a'] = num;  // 更新当前字符结尾的子序列数量
        }
        return (int) ans % mod;  // 返回最终结果取模
    }

    //我不明白的是，为什么方法1不能过，方法2能过？同样的思路

    //方法2
    static long [] dp = new long [26];
    public int distinctSubseqII(String s) {
        Arrays.fill(dp,0);
        char [] chars = s.toCharArray();
        long ans = 0;
        for(char c:chars){
            long old_dp_c = dp[c - 'a'];
            dp[c - 'a'] = (ans + 1) % mod;
            ans = (ans + dp[c - 'a'] - old_dp_c + mod) % mod;
        }
        return (int)ans%mod;
    }


}
