package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No639 {
    public static void main(String[] args) {
        System.out.println(numDecodings("*1"));
    }


    public static long mod = 1000000007;
    static long [] dp = new long[100000];
    public static int numDecodings(String s) {
        char[] chars = s.toCharArray();
        Arrays.fill(dp,0);
        dp[chars.length]=1;
        for (int index = chars.length-1;index>=0;index--){
            long ans = 0;
            if (chars[index]=='0'){
                dp[index]=0;
                continue;
            }
            if (chars[index]=='*'){
                ans = 9*dp[index+1];
                if (index+1<chars.length){
                    if (chars[index+1]=='*'){
                        ans+=15*dp[index+2];
                    }else {
                        ans+=dp[index+2];
                        if (chars[index+1]<'7'){
                            ans+=dp[index+2];
                        }
                    }
                }
            }else{
                ans+=dp[index+1];
                if (index+1<chars.length){
                    if (chars[index+1]=='*'){
                        if (chars[index]=='1'){
                            ans+=9*dp[index+2];
                        }else if (chars[index]=='2'){
                            ans+=6*dp[index+2];
                        }
                    }else {
                        int result = 10*(chars[index]-'0')+(chars[index+1]-'0');
                        if (result<27){
                            ans+=dp[index+2];
                        }
                    }
                }
            }
            dp [index] = (ans%mod);
        }
        return (int) dp[0];
    }

//    public static int numDecodings1(String s) {
//        char[] chars = s.toCharArray();
//        dp = new int[chars.length+1];
//        dp[chars.length]=1;
//        Arrays.fill(dp,-1);
//        return (process(chars,0)%1000000007);
//    }

//    public static int process(char [] chars,int index){
//        if (index==chars.length){
//            return 1;
//        }
//        int ans = 0;
//        if (dp[index]!=-1){
//            return dp[index];
//        }
//        //当前字符的情况数目
//        if (chars[index]=='0'){
//            return 0;
//        }
//        if (chars[index]=='*'){
//            ans = 9*process(chars,index+1);
//            if (index+1<chars.length){
//                if (chars[index+1]=='*'){
//                    ans+=15*process(chars,index+2);
//                }else {
//                    ans+=process(chars,index+2);
//                    if (chars[index+1]<'7'){
//                        ans+=process(chars,index+2);
//                    }
//                }
//            }
//        }else{
//            ans+=process(chars,index+1);
//            if (index+1<chars.length){
//                if (chars[index+1]=='*'){
//                    if (chars[index]=='1'){
//                        ans+=9*process(chars,index+2);
//                    }else if (chars[index]=='2'){
//                        ans+=6*process(chars,index+2);
//                    }
//                }else {
//                    int result = 10*(chars[index]-'0')+(chars[index+1]-'0');
//                    if (result<27){
//                        ans+=process(chars,index+2);
//                    }
//                }
//            }
//        }
//        dp [index] = ans;
//        return (int) (ans%mod);
//    }
}
