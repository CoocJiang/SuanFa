package A_leetcode.leetcodeall;

import java.util.Arrays;

public class NO688 {

    public static void main(String[] args) {
        System.out.println(knightProbability(3, 2, 0, 0));
    }
    static int [] movex = new int[]{1,2,2,1,-1,-2,-2,-1};
    static int [] movey = new int[]{2,1,-1,-2,2,1,-1,-2};
    static double [][][]dp = new double[101][25][25];
    public static double knightProbability(int n, int k, int row, int column) {
        for (int i =0;i<n;i++){
            Arrays.fill(dp[0][i],1);
        }
        for (int i = 1;i<=k;i++){
            for (int j = 0;j<n;j++){
                for (int l = 0;l<n;l++){
                    double ans = 0;
                    int nrow;
                    int ncol;
                    for (int index = 0;index<movex.length;index++){
                        nrow = j+movex[index];
                        ncol = l+movey[index];
                        if (nrow>=n||nrow<0||ncol>=n||ncol<0){
                            continue;
                        }
                        ans+=dp[i-1][nrow][ncol]/8;
                    }
                    dp[i][j][l] = ans;
                }
            }
        }
        return dp[k][row][column];
    }
}
