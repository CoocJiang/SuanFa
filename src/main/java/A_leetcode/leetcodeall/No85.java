package A_leetcode.leetcodeall;

public class No85 {

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle(matrix));
    }
    static int [] stack;
    static int max;

    static int [] cols;

    static int [][] ans;

    static int r;
    public static int maximalRectangle(char[][] matrix) {
        ans = new int[matrix[0].length][2];
        stack = new int [matrix[0].length];
        cols = new int[matrix[0].length];
        max = 0;
        ans[matrix[0].length-1][1] = matrix[0].length;
        ans[0][0] = -1;
        for (int i=0;i<matrix.length;i++){
            r=0;
           for (int j = 0;j<matrix[0].length;j++){
               //进行数组压缩
               if (matrix[i][j]=='1'){
                   cols[j] = cols[j]+1;
               }else {
                   cols[j]=0;
               }
               if (r-1>=0){
                   ans[j][0] = stack[r-1];
               }
               //当此时的数小于栈里的数时，就一直弹出
               while (r>0&&cols[j]<cols[stack[r-1]]){
                   ans[j][0] = ans[stack[r-1]][0];
                   ans[stack[r-1]][1]=j;
                   max = Math.max(max,cols[stack[r-1]]*(ans[stack[r-1]][1]-ans[stack[r-1]][0]-1));
                   r--;
               }
               stack[r++] = j;
           }
            max = Math.max(cols[stack[r-1]]*(ans[stack[r-1]][1]-ans[stack[r-1]][0]-1),max);
            r--;
            while (r>0){
                ans[stack[r-1]][1] = ans[stack[r]][1];
                max = Math.max(max,cols[stack[r-1]]*(ans[stack[r-1]][1]-ans[stack[r-1]][0]-1));
                r--;
            }
        }
        return max;
    }
}
