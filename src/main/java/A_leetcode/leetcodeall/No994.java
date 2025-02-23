package A_leetcode.leetcodeall;

import java.util.ArrayDeque;
import java.util.Queue;

public class No994 {
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        System.out.println(orangesRotting(matrix));
    }
    static int [] arr = new int[]{1,0,-1,0,1};
    public static int orangesRotting(int[][] grid) {
        int n  = grid.length;
        int m = grid[0].length;
        Queue<int []> queue  =  new ArrayDeque<>();
        for (int i = 0;i<grid.length;i++){
            for (int j = 0;j<grid[0].length;j++){
                if (grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        if (queue.isEmpty()){
            return 0;
        }
        int minute = 0;
        boolean flag = false;
        int size = queue.size();
        int newsize = 0;
        while (!queue.isEmpty()){
            int [] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 1;i<arr.length;i++){
                int nx = x+arr[i-1];
                int ny = y+arr[i];
                if (nx>=0&&nx<n&&ny>=0&&ny<m&&grid[nx][ny]==1){
                    grid[nx][ny] = 2;
                    queue.add(new int[]{nx,ny});
                    if (!flag){
                        newsize++;
                    }else {
                        size++;
                    }
                }
            }
            if (!flag){
                size--;
                if (size==0){
                    flag = true;
                    minute++;
                }
            }else {
                newsize--;
                if (newsize==0){
                    flag = false;
                    minute++;
                }
            }
        }
        for (int i = 0;i<grid.length;i++){
            for (int j = 0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                   return -1;
                }
            }
        }
        return Math.max(minute - 1, 0);
    }
}
