package A_leetcode.leetcodeall;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class No2290 {

    public static void main(String[] args) {
        System.out.println(minimumObstacles(new int[][]{{0, 1, 1}, {1, 1, 0}, {1, 1, 0}}));
    }
    //[0,1,0,-1,0]
    static int [] move = {0,1,0,-1,0};
    public static int minimumObstacles(int[][] grid) {
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
                if (r< grid.length&&c<grid[0].length&&r>=0&&c>=0&&(distance[r][c]>(distance[row][col]+grid[r][c]))){
                        distance[r][c] = distance[row][col]+grid[r][c];
                        if (grid[r][c]==0){
                            //如果距离是0，从头入队列
                            deque.addFirst(new int[]{r,c});
                        }else {
                            //如果距离是1，尾入队列
                            deque.addLast(new int[]{r,c});
                        }
                }
            }
        }
        return distance[n-1][m-1];
    }
}
