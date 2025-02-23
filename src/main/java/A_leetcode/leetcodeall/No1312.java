package A_leetcode.leetcodeall;

public class No1312 {

    public static void main(String[] args) {
        System.out.println(minInsertions("leetcode"));
    }

    public static int minInsertions(String s) {
        int [][] dp = new int[s.length()][s.length()];
        char [] chars = s.toCharArray();
        for(int i = 0;i<chars.length-1;i++){
            dp[i][i] = 0;
            dp[i][i+1] = chars[i]==chars[i+1] ? 0:1;
        }
        dp[chars.length-1][chars.length-1] = 0;
        for(int i = chars.length-3;i>=0;i--){
            for(int j = i+2;j<chars.length;j++){
                if(chars[i]==chars[j]){
                    dp[i][j] =dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.min(1+dp[i+1][j],1+dp[i][j-1]);
                }
            }
        }
        return dp[0][chars.length-1];
        //return process(chars,0,chars.length-1); //递归版本
    }
//    public int process(char [] chars,int l,int r){
//        if(dp[l][r]!=-1){
//            return dp[l][r];
//        }
//        if(l+1==r){
//            dp[l][r] = chars[l]==chars[r] ? 0:1;
//            return dp[l][r];
//        }
//        //剩下的元素不止两个
//        if(chars[l]==chars[r]){
//            dp[l][r] = process(chars,l+1,r-1);
//            return  dp[l][r] ;
//        }else{
//            int p1 = 1 + process(chars,l+1,r);
//            int p2 = 1 + process(chars,l,r-1);
//            dp[l][r] = Math.min(p1,p2);
//            return dp[l][r];
//        }
//    }
}
