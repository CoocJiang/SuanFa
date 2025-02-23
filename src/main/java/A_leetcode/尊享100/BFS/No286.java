package A_leetcode.尊享100.BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class No286 {
    public static void main(String[] args) {
        int[][] maze = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };
        wallsAndGates(maze);
    }

    public static void printMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int [] move= new int[]{1,0,-1,0,1};
    public static void wallsAndGates(int[][] rooms) {
        int n = rooms.length;
        int m = rooms[0].length;
        Queue<int []> queue = new ArrayDeque<>();
        for (int row = 0;row<rooms.length;row++){
            for (int col = 0;col<rooms[0].length;col++){
                 if (rooms[row][col]==0){
                    queue.add(new int[]{row,col});
                }
            }
        }
        while (!queue.isEmpty()){
            int [] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            //对这个门进行bFS
            for (int i =1;i<move.length;i++){
                int newrow = row+move[i-1];
                int newcol = col+move[i];
                int distance = rooms[row][col]+1;
                if (newrow>=0&&newrow<n&&newcol>=0&&newcol<m&&(rooms[newrow][newcol])!=-1&&distance<rooms[newrow][newcol]){
                    rooms[newrow][newcol] =distance;
                    queue.add(new int[]{newrow,newcol});
                }
            }
        }
        printMaze(rooms);
    }
}
