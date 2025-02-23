package A_leetcode.尊享100.BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class No505 {
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
        System.out.println(shortestDistance(maze, start, destination));

    }
    static int [][] move = {{},{0,1},{0,-1},{1,0},{-1,0}};

    public  static int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        int [][] distance = new int[n][m];
        for (int i=0;i<distance.length;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        Queue<int []> queue = new ArrayDeque<>();
        queue.offer(new int[]{start[0],start[1]});
        while (!queue.isEmpty()){
            int [] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            for (int i=1;i<move.length;i++){
                int distan = distance[row][col];
                int newrow = row;
                int newcol = col;
                while (newrow>=0&&newcol>=0&&newcol<maze[0].length&&newrow<maze.length&&maze[newrow][newcol]!=1){
                    newrow += move[i][0];
                    newcol +=move[i][1];
                    distan++;
                }
                distan--;
                if (distan<distance[newrow-move[i][0]][newcol-move[i][1]]){
                    queue.offer(new int[]{newrow-move[i][0],newcol-move[i][1]});
                    distance[newrow-move[i][0]][newcol-move[i][1]] = distan;
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ?-1:distance[destination[0]][destination[1]];
    }
}
