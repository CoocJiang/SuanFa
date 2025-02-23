package A_leetcode.leetcodeall;

import java.util.*;

public class No2850 {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 2},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(minimumMoves(array));
    }
    static int n = 3;

    static int [][] arrstart;

    static int [][] arrend;

    static int end,start;
//    public static int minimumMoves1(int[][] grid) {
//        //记录下所有多余一个石头的点，和所有只有 0 个石头的点
//        arrstart = new int[9][3];
//        start = 0;
//        end = 0;
//        arrend = new int[9][2];
//        boolean [][] visited = new boolean[3][3];
//        for (int i = 0;i<n;i++){
//            for (int j = 0;j<n;j++){
//                if (grid[i][j]>1){
//                    arrstart[start][0] = i;
//                    arrstart[start][1] = j;
//                    arrstart[start++][2] = grid[i][j];
//                }else if(grid[i][j]==0){
//                    arrend[end][0] = i;
//                    arrend[end++][1] = j;
//                    visited[i][j] = true;
//                }
//            }
//        }
//        int steps = 0;
//        for (int k = 0;k<start;k++){
//            int [] curstart = arrstart[k];
//            while (curstart[2]>1){
//                int minsteps = Integer.MAX_VALUE;
//                int index = 0;
//                //遍历所有石头数大于1的点看哪一个最近
//                for (int i = 0;i<end;i++){
//                    int [] curend = arrend[i];
//                    if (!visited[curend[0]][curend[1]]){
//                        continue;
//                    }
//                    int step = Math.abs(curstart[0]-curend[0])+Math.abs(curstart[1]-curend[1]);
//                    if (minsteps>step){
//                        index = i;
//                        minsteps=step;
//                        if (step==1){
//                            break;
//                        }
//                    }
//                }
//                visited[arrend[index][0]][arrend[index][1]] = false;
//                steps+=minsteps;
//                curstart[2]--;
//            }
//        }
//        return steps;
//    }

    public static int minimumMoves(int[][] grid) {
        //记录下所有多余一个石头的点，和所有只有 0 个石头的点
        List<int []> from = new ArrayList<>();
        List<int []> to = new ArrayList<>();
        for (int i = 0;i<3;i++){
            for (int j = 0;j<3;j++){
                if (grid[i][j]>1){
                    while (grid[i][j]>1){
                        from.add(new int[]{i,j});
                    }
                }else if(grid[i][j]==0){
                    to.add(new int[]{i,j});
                }
            }
        }

        return 0;
    }


}
