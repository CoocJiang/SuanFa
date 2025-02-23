package A_leetcode.leetcodeall;

public class No44 {

    public static void main(String[] args) {
        System.out.println(isMatch("adceb", "*a*b"));
    }
    static int [][]dp;
    public  static boolean isMatch(String s, String p) {
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
        if (indexp==charp.length){
            if (indexs==chars.length){
                dp[indexs][indexp] = 1;
                return true;
            }else{
               return false;
            }
        }
        //开始匹配
        //后面一个是’*‘
        if (charp[indexp]=='*'){
            //当前就[indexp]就可以选择从0...到n个，完全背包模板
            boolean p1 = process(chars,charp,indexs,indexp+1);
            boolean p2 = indexs < chars.length && process(chars, charp, indexs + 1, indexp);
            dp[indexs][indexp]=p1||p2 ? 1:2;
            return dp[indexs][indexp]==1;
        }else {
            if (indexs<chars.length&&(chars[indexs]==charp[indexp]||charp[indexp]=='?')){
                dp[indexs][indexp] =process(chars,charp,indexs+1,indexp+1) ? 1:2;
                return dp[indexs][indexp]==1;
            }
        }
        return false;
    }
}
