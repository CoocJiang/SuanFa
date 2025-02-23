package mt;

public class No48 {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(matrix);
    }
    static int n;
    public static void rotate(int[][] matrix) {
        n = matrix.length-1;
        int time = (n+1)/2;
        for (int i = 0;i<time;i++){
            for (int j = i;j<=n-i;j++){
                swap(i,j,matrix);
            }
        }
    }

    private static void swap(int x, int y, int[][] matrix) {
        int temp = matrix[n-y][x];
        matrix[n-y][x] = matrix[n-x][n-y];
        matrix[n-x][n-y] = matrix[y][n-x];
        matrix[y][n-x] = matrix[x][y];
        matrix[x][y] = temp;
    }


}
