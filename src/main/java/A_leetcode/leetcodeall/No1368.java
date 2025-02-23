package A_leetcode.leetcodeall;

import java.util.ArrayDeque;
import java.util.Arrays;

public class No1368 {


    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{{1, 1, 3}, {3, 2, 2}, {1, 1, 4}}));
    }
    static int [] move = {0,1,0,-1,0};

    public static int minCost(int[][] grid) {
        int n = grid.length;;
        int m = grid[0].length;
        //存储起点点到其他点的距离
        int [][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[0][0] = 0;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new  int[]{0,0});
        while (!deque.isEmpty()){
            int [] cur = deque.getFirst();
            deque.removeFirst();
            int row = cur[0];
            int col = cur[1];
            if (row == n - 1 && col == m - 1) {
                return distance[row][col];
            }
            for (int i=0;i<move.length-1;i++){
                int r = row+move[i];
                int c = col+move[i+1];
                if (r< grid.length&&c<grid[0].length&&r>=0&&c>=0){
                    int distances = distance[row][col];
                    if (grid[row][col]==1&&(c!=col+1)){
                        distances++;
                    }
                    if (grid[row][col]==2&&(c!=col-1)){
                        distances++;
                    }
                    if (grid[row][col]==3&&(r!=row+1)){
                        distances++;
                    }
                    if (grid[row][col]==4&&(r!=row-1)){
                        distances++;
                    }
                    if (distance[r][c]>distances){
                        distance[r][c] = distances;
                        if (distances==distance[row][col]){
                            //如果距离是0，从头入队列
                            deque.addFirst(new int[]{r,c});
                        }else {
                            //如果距离是1，尾入队列
                            deque.addLast(new int[]{r,c});
                        }
                    }
                }
            }
        }
        return distance[n-1][m-1];
    }
}
