package A_leetcode.leetcodeall;

public class No97 {
    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc","dbbca", "aadbbcbcac"));
    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        int l1 = 0;
        int l2 = 0;
        int l3 = 0;
        int n = s1.length();
        int m = s2.length();
        int q = s3.length();
        char [] chars1 = s1.toCharArray();
        char [] chars2 = s2.toCharArray();
        char [] chars3 = s3.toCharArray();
        if(n+m!=q){
            return false;
        }
        boolean [][] dp = new boolean[q+1][q+1];
        for (int i = 0;i<=q;i++){
            dp[i][q] = true;
        }
        for (int i = q;i>=0;i--){
            for (int j = q-1;j>=0;j--){
                boolean flag1 = false;
                boolean flag2 = false;
                if(i<chars1.length&&chars1[i]==chars3[j]){
                    flag1 = dp[i+1][j+1];
                }
                if(j-i>=0&&j-i<chars2.length&&chars2[j-i]==chars3[j]){
                    flag2 = dp[i][j+1];
                }
                dp[i][j] = flag1||flag2;
            }
        }
       return dp[0][0];
    }


    public static boolean process(int l1,int l3,char []chars1,char [] chars2,char []chars3){
        //basecase
        if(l3==chars3.length){
            return true;
        }
        boolean flag1 = false;
        boolean flag2 = false;
        if(l1<chars1.length&&chars1[l1]==chars3[l3]){
            flag1 = process(l1+1,l3+1,chars1,chars2,chars3);
        }
        if(l3-l1<chars2.length&&chars2[l3-l1]==chars3[l3]){
            flag2 = process(l1,l3+1,chars1,chars2,chars3);
        }
        return flag1||flag2;
    }
}
