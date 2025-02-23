package A_leetcode.leetcodeall;

public class No62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }
    public static int uniquePaths(int m, int n) {
        int [][]dp = new int[m][n];

        for(int i = 0;i<m;i++){
            dp[i][n-1] = 1;
        }
        for(int i = 0;i<n;i++){
            dp[m-1][i] = 1;
        }
        for(int row = m-2;row>=0;row--){
            for(int col = n-2;n>=0;n--){
                dp[row][col] = dp[row+1][col]+dp[row][col+1];
            }
        }
        return dp[0][0];
    }
}
