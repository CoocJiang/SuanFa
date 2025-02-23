package A_leetcode.leetcodeall;

import java.util.HashMap;
import java.util.HashSet;

public class No10 {


    public static void main(String[] args) {
        System.out.println(isMatch("mississippi","mis*is*p*."));
    }

    static int [][]dp;
    public static boolean isMatch(String s, String p) {
        char[] chars = s.toCharArray();
        char[] charp = p.toCharArray();
        dp = new int[chars.length+1][charp.length+1];
        dp[chars.length][charp.length]=1;
        return process(chars,charp,0,0);
    }

    private static boolean process(char[] chars, char[] charp, int indexs,int indexp) {
        if (dp[indexs][indexp]!=0){
            return dp[indexs][indexp]==1;
        }
        //如果匹配到字符完结 直接return true
        if (indexs==chars.length){
            if (indexp==charp.length){
                dp[indexs][indexp] = 1;
                return true;
            }else{
                //如果p字符串还有 字符 判断后面是否是字母+*结尾的，是的话也可以当作没有字符，反之返回false
                dp[indexs][indexp] = indexp+1<charp.length&&charp[indexp+1]=='*'&&process(chars,charp,indexs,indexp+2) ? 1:2;
                return dp[indexs][indexp]==1;
            }
        }
        //开始匹配
        //后面一个是’*‘
        if (indexp+1<charp.length&&charp[indexp+1]=='*'){
            //当前就[indexp]就可以选择从0...到n个，完全背包模板
            boolean p1 = process(chars,charp,indexs,indexp+2);
            boolean p2 = process(chars,charp,indexs+1,indexp)&&(charp[indexp]==chars[indexs]||charp[indexp]=='.');
            dp[indexs][indexp]=p1||p2 ? 1:2;
            return dp[indexs][indexp]==1;
        }else {
            if (indexp<charp.length&&(chars[indexs]==charp[indexp]||charp[indexp]=='.')){
                dp[indexs][indexp] =process(chars,charp,indexs+1,indexp+1) ? 1:2;
                return dp[indexs][indexp]==1;
            }
        }
        return false;
    }
}
