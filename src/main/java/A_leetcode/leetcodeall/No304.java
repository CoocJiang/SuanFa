package A_leetcode.leetcodeall;

public class No304 {

    public static void main(String[] args) {

        int[][] array = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1},{1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix n = new NumMatrix(array);
        System.out.println(n.sumRegion(2, 1, 4, 3));
    }


    static class NumMatrix {
        static int [][] arr;

        public NumMatrix(int[][] matrix) {
            arr = new int[matrix.length+1][matrix[0].length+1];
            for (int i = 0;i<matrix.length;i++){
                arr[i][0] = 0;
            }
            for(int i = 0;i<matrix[0].length;i++ ){
                arr[0][i] = 0;
            }
            for(int i = 1;i<arr.length;i++ ){
                for(int j = 1;j<arr[0].length;j++){
                    arr[i][j] = arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1]+matrix[i-1][j-1];
                }
            }
        }
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return arr[row2+1][col2+1] - arr[row2+1][col1] - arr[row1][col2+1] + arr[row1][col1];
        }
    }
}
