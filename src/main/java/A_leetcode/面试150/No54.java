package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.List;

public class No54 {
    //给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
    //输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
    //输出：[1,2,3,6,9,8,7,4,5]
    public static void main(String[] args) {
        int [][] mar = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        for (int i:spiralOrder(mar)){
            System.out.println(i);
        }
    }


    public static List<Integer> spiralOrder(int[][] matrix) {
       List<Integer> list = new ArrayList<>();
        int L = 0;
        int R = matrix[0].length;
        int T = 0;
        int B = matrix.length;
        while (list.size()<  matrix.length*matrix[0].length){
            for (int i=L;i<R;i++){
                list.add(matrix[T][i]);
            }
            T++;
            for (int i=T;i<B;i++){
                list.add(matrix[i][R-1]);
            }
            R--;
            for (int i=R-1;i>L;i--){
                list.add(matrix[B-1][i]);
            }
            B--;
            for (int i=B-1;i>T;i--){
                list.add(matrix[i][L]);
            }
            L++;
       }
        return list;
    }

}
