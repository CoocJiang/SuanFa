package b_b动态规划.暴力递归;

public class 最长回文子序列 {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longest2(s));
    }
    public static int longest(String str){
        if (str==null){
            return 0;
        }
        return process1(str.toCharArray(),0,str.length()-1);
    }
    private static int process1(char[] charArray, int l, int r) {
        //长度为1时，自己与自己回文子序列
        if (l==r){
            return 1;
        }
//        长度为2时，如果相等就是2，不想等就只有1个
        if (r-l==1){
            return charArray[l]==charArray[r] ? 2:1;
        }
        //长度大于2时，就有很多情况了

        //1 如果首尾相等 直接看下一个
        int o =0;
        if (charArray[l]==charArray[r]){
             o= 2+process1(charArray,l+1,r-1);
        }
        //2 如果首尾不等，有两种情况，左移动，或者右移动，我们都考虑，取最大值就可以了
        int p =process1(charArray,l+1,r);
        //3
        int q= process1(charArray,l,r-1);
        return Math.max(q,Math.max(o,p));
    }
    //动态规划优化
    public static int longest2(String str){
        if (str==null){
            return 0;
        }int [][] dp = new int[str.length()][str.length()];
        char [] chars = str.toCharArray();
        dp[0][0] = 1;
        for (int j = 1;j<chars.length;j++){
            for (  int i =chars.length-1;i>=0;i--){
                if (i==j){
                    dp[i][j] = 1;
                    continue;
                } if (j-i==1){
                    dp[i][j] =chars[j]==chars[i] ? 2:1;
                    continue;
                }
                    int o =0;
                    int p = 0;
                    int q = 0;
                    if (i+1<chars.length&&i<j&&chars[i]==chars[j]){
                        o=2 + dp[i+1][j-1];
                    }else if(i+1<chars.length) {
                        q = dp[i + 1][j];
                        p = dp[i][j-1];
                    }
                    dp[i][j] = Math.max(Math.max(o,p),q);
            }
        }
        return dp[0][chars.length-1];
    }

}
