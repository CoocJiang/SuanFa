package A_leetcode.尊享100.BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class No1197 {
    public static void main(String[] args) {
        System.out.println(minKnightMoves(300, 0));
    }
    static int [][] visited = new int[601][601];
    static int [][] move ={{2,1},{1,2},{-2,1},{-1,2},{-2,-1},{-1,-2},{2,-1},{1,-2}};

    //单向bfs
    public static int minKnightMoves(int x, int y) {
        x=300+x;
        y=300+y;
        for (int i=0;i<visited.length;i++){
            Arrays.fill(visited[i],Integer.MAX_VALUE);
        }
        visited[300][300] = 0;
        Queue<int []> queue = new ArrayDeque<>();
        queue.add(new int[]{300,300});
        while (!queue.isEmpty()){
            int [] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            if (row==x&&col==y){
                return visited[row][col];
            }
            for (int i=0;i<move.length;i++){
                int distance = visited[row][col];
                int newrow = row+move[i][0];
                int newcol = col+move[i][1];
                distance++;
                if (newrow<602&&newrow>=0&&newcol<602&&newcol>=0&&visited[newrow][newcol]>distance){
                    queue.add(new int[]{newrow,newcol});
                    visited[newrow][newcol]=distance;
                }
            }
        }
        return -1;
    }
}
