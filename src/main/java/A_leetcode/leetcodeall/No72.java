package A_leetcode.leetcodeall;

public class No72 {
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }

//    public static int minDistance(String word1, String word2) {
//        //dp[i][j]代表 当前使word1 == word2所做的的操作数
//        char[] chars1 = word1.toCharArray();
//        char[] chars2 = word2.toCharArray();
//        int n = chars1.length;
//        int m = chars2.length;
//        int [][] dp = new int[n+1][m+1];
//        //本身就等于dp[i-1][j]+1;
//        //if(word1[i-1] == word[j-1])  当前字符就等于 dp[i][j] = dp[i-1][j-1]
//        //如果不相等  dp[i][j] = dp[i-1][j-1]+1;
//
//        for(int i = 0;i<=n;i++){
//            dp[i][0]=i;
//        }
//        for (int i = 1;i<=m;i++){
//            dp[0][i] = i;
//        }
//        for (int i = 1;i<=n;i++){
//            for (int j = 1;j<=m;j++){
//                int p1 = dp[i-1][j]+1;
//                int p2 = dp[i][j-1]+1;
//                if (chars1[i-1]==chars2[j-1]){
//                    p1 = Math.min( dp[i-1][j-1],p1);
//                }else{
//                    p1 = Math.min(dp[i-1][j-1]+1,p1);
//                }
//                dp[i][j] = Math.min(p1,p2);
//            }
//        }
//        return dp[n][m];
//    }

    public static int minDistance(String word1, String word2) {

        int [][] dp = new int[word1.length()+1][word2.length()+1];

        for (int i = 0;i<word1.length();i++){
            dp[i][word2.length()] = word1.length() - i;
        }
        for (int i = 0;i<word2.length();i++){
            dp[word1.length()][i] = word2.length() - i;
        }
        for (int i = word1.length()-1;i>=0;i--){
            for (int j = word2.length()-1;j>=0;j--){
                int p1 = Integer.MAX_VALUE;
                if (word1.charAt(i)==word2.charAt(j)){
                    p1 = dp[i+1][j+1];
                }
                p1 = Math.min(1+dp[i+1][j],p1);
                p1 = Math.min(1+dp[i+1][j+1],p1);
                p1 = Math.min(1+dp[i][j+1],p1);
                dp[i][j] = p1;
            }
        }
        return dp[0][0];
    }

    public static int process(int l,int r,String word1, String word2){
        if (l==word1.length()){
            return word2.length() - r;
        }else if (r==word2.length()){
            return word1.length() - l;
        }else {
            int p1 = Integer.MAX_VALUE;
            //相等
            if (word1.charAt(l)==word2.charAt(r)){
                p1 = process(l+1,r+1,word1,word2);
            }
            //插入
            int p2 = 1+process(l,r+1,word1,word2);
            //替换
            p2 = Math.min(1+process(l+1,r+1,word1,word2),p2);
            //删除
            p2 = Math.min(1+process(l+1,r,word1,word2),p2);
            return Math.min(p1,p2);
        }
    }
}
