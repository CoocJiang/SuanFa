package A_leetcode.尊享100.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class No490 {

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };

        int[] start = {0, 4};
        int[] destination = {4, 4};
        System.out.println(hasPath(maze, start, destination));

    }
    static int [][] move = {{},{0,1},{0,-1},{1,0},{-1,0}};
    public  static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int []> queue = new ArrayDeque<>();
       visited[start[0]][start[1]] = true;
       queue.offer(new int[]{start[0],start[1]});
        while (!queue.isEmpty()){
            int [] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            if (row==destination[0]&&col==destination[1]){
                return true;
            }

            for (int i=1;i<move.length;i++){
                 int newrow = row+move[i][0];
                 int newcol = col+move[i][1];
                 while (newrow>=0&&newcol>=0&&newcol<maze[0].length&&newrow<maze.length&&maze[newrow][newcol]!=1){
                     newrow += move[i][0];
                     newcol +=move[i][1];
                 }
                 if (!visited[newrow - move[i][0]][newcol - move[i][1]]){
                     visited[newrow-move[i][0]][newcol-move[i][1]]=true;
                     queue.offer(new int[]{newrow-move[i][0],newcol-move[i][1]});
                 }
            }
        }
        return false;
    }
}
