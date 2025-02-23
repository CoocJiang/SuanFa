package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No583 {
    public static void main(String[] args) {
        System.out.println(minDistance("a","ab"));
    }


    static int [][] dp;
    public static int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        for (int i = 0;i<word1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return process(0,0,word1,word2);
    }

    private static int process(int i, int j, String word1, String word2) {
        if (i==word1.length()){
            int ans = 0;
            while (j<word2.length()){
                ans+=word2.charAt(j++);
            }
            return ans;
        }else if (j==word2.length()){
            int ans = 0;
            while (i<word1.length()){
                ans+=word1.charAt(i++);
            }
            return ans;
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        if (word1.charAt(i)==word2.charAt(j)){
            min =  process(i+1,j+1,word1,word2);
        }else {
            int p1 = word1.charAt(i)+process(i+1,j,word1,word2);
            int p2 = word2.charAt(j)+process(i,j+1,word1,word2);
            min = Math.min(p1,p2);
        }
        dp[i][j] = min;
        return min;
    }
}
