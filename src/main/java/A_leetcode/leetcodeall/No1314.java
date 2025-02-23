package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No1314 {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Arrays.stream(matrixBlockSum(array,1));
    }

    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0;i<n;i++){
            int sum = 0;
            for (int j = 0;j<m;j++){
                sum+=mat[i][j];
                mat[i][j] = sum;
            }
        }

        int [][] ans = new int[n][m];
        for (int i = 0;i<n;i++){
            int rmin = Math.max(0,i-k);
            int rmax = Math.min(n-1,i+k);
            for (int j = 0;j<m;j++){
                int jmin = Math.max(0,j-k);
                int jmax = Math.min(m-1,j+k);
                int answer = 0;
                if (jmin>0){
                    for (int l = rmin;l<=rmax;l++){
                        answer+=mat[l][jmax] - mat[l][jmin-1];
                    }
                }else {
                    for (int l = rmin;l<=rmax;l++){
                        answer+=mat[l][jmax];
                    }
                }
                ans[i][j] = answer;
            }
        }
        return ans;
    }
}
