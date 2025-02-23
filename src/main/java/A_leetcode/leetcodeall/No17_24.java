package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No17_24 {
    public static void main(String[] args) {
        // Define the matrix
        int[][] matrix = {
                { -1,0 },
                {0,-1}
        };
        for (int maxMatrix : getMaxMatrix(matrix)) {
            System.out.println(maxMatrix);
        }
    }
    //使用arr作为压缩数组
    static int [] arr = new int[200];
    static int [] ans = new int[4];
    public static int[] getMaxMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        //大思路 从第一行 开始，考虑1-1,1-2....1-n组成的矩阵中最大的
        //再从第二行开始 2-2，2-3...2-n;一直到 n-n，能够包含所有的矩阵
        int max = Integer.MIN_VALUE;
        for (int up = 0;up<n;up++){
            Arrays.fill(arr,0);
            for (int down = up;down<n;down++){
                for (int i = 0;i<m;i++){
                    arr[i] += matrix[down][i];
                }
                //数组压缩完毕
                int l = 0;//记录数组的最左边
                //找到数组中最大的字数组
                int pre = Integer.MIN_VALUE;
                for (int i = 0;i<m;i++){
                    if (pre>0){
                        pre+=arr[i];
                    }else {
                        pre = arr[i];
                        l = i;
                    }
                    if (pre>max){
                        max = pre;
                        ans[0] = up;
                        ans[1] = l;
                        ans[2] = down;
                        ans[3] = i;
                    }
                }
            }
        }
        return ans;
    }
}
