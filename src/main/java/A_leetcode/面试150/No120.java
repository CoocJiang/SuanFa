package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.List;

public class No120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

// 第一行
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(2);
        triangle.add(row1);

// 第二行
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);
        triangle.add(row2);

// 第三行
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(6);
        row3.add(5);
        row3.add(7);
        triangle.add(row3);

// 第四行
        ArrayList<Integer> row4 = new ArrayList<>();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);
        triangle.add(row4);

        System.out.println(minimumTotal2(triangle));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int [][] dp = new int[triangle.size()][triangle.size()];
        return process1(triangle,dp,0,0);
    }

    public static int process1(List<List<Integer>> triangle,int[][] dp,int row,int colum){
        if (dp[row][colum]!=0){
            return dp[row][colum];
        }
       if (row==triangle.size()-1){
           return triangle.get(row).get(colum);
       }
       int p1 = triangle.get(row).get(colum)+process1(triangle,dp,row+1,colum);
       int p2 = triangle.get(row).get(colum)+process1(triangle,dp,row+1,colum+1);
       dp[row][colum] = Math.min(p1,p2);
       return dp[row][colum];
    }
    //动态规划优化
    public static int minimumTotal2(List<List<Integer>> triangle){
        int [][] dp = new int[triangle.size()][triangle.size()];
        //很容易得到，每一行都依赖于下一行
        for (int i = 0 ;i<triangle.size();i++){
            dp[triangle.size()-1][i] = triangle.get(triangle.size()-1).get(i);
        }
        for (int i = triangle.size()-2;i>=0;i--){
            for (int j =0;j<=i;j++){
                dp[i][j] =triangle.get(i).get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }

}
