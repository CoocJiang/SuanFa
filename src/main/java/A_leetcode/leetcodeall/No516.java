package A_leetcode.leetcodeall;

public class No516 {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
    public static int longestPalindromeSubseq(String s) {
        char [] chars = s.toCharArray();
        int l = 0;
        int r = s.length()-1;
        int [][]dp = new int[r+1][r+1];
        for(int i = 0;i<=r;i++){
            dp[i][i] = 1 ;
        }
        for(int row = r-1;row>=0;row--){
            for(int col = row+1;col<r+1;col++){
                //当前两种情况 首位字符是否相等
                if(chars[row]==chars[col]){
                    dp[row][col] = 2+dp[row+1][col-1];
                }else{
                    int p1 = Math.max(dp[row+1][col],dp[row][col-1]);
                    dp[row][col] = p1;
                }
            }
        }
        return dp[0][r];
    }
    public static int process(int l,int r,char[] s){
        if(l==r){
            return 1;
        }else if(l>r){
            return 0;
        }
        //当前两种情况 首位字符是否相等
        if(s[l]==s[r]){
            return 2+process(l+1,r-1,s);
        }else{
            int p1 = Math.max(process(l+1,r,s),process(l,r-1,s));
            return p1;
        }
    }
}
