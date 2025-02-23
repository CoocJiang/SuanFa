package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No91 {

    public static void main(String[] args) {
        System.out.println(numDecodings("06"));
    }
    static char [] str;
    static int [] dp;
    public static int numDecodings(String s) {
        str = s.toCharArray();
        dp = new int[s.length()+1];
        dp[str.length] = 1;
        if (str[str.length-1]=='0'){
            dp[str.length-1] = 0;
        }else {
            dp[str.length-1] = 1;
        }
        for (int index = str.length-2;index>=0;index--){
            int cha = (str[index]-'0')*10+str[index+1]-'0';
            if (str[index]=='0'){
                continue;
            }else if (cha<27){
                dp[index] = dp[index+1]+dp[index+2];
            }else {
                dp[index] = dp[index+1];
            }
        }
        return dp[0];
    }


    public static int process(int index){
        if (index==str.length){
            return 1;
        }
        if (str[index]=='0'){
            return 0;
        }
        if (dp[index]!=-1){
            return dp[index];
        }
        int result = 0;
        int cha = str[index]-'0';
        if (index+1<str.length){
            int nextcha = str[index+1]-'0';
            if (cha<3&&nextcha==0){
                result+=process(index+2);
            }else if (cha == 1){
                result+=process(index+1)+process(index+2);
            }else if(cha==2&&nextcha<7){
                result+=process(index+1)+process(index+2);
            } else {
                result+=process(index+1);
            }
        }else{
            result+=process(index+1);
        }
        dp[index] = result;
        return result;
    }
}
