package A_leetcode.尊享100.BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class No499 {
    static int [][] move = {{},{0,1},{0,-1},{1,0},{-1,0}};
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int n = maze.length;
        int m = maze[0].length;
        String [][] distance = new String[n][m];
        for (int i=0;i<distance.length;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }
        distance[ball[0]][ball[1]] = "";
        Queue<int []> queue = new ArrayDeque<>();
        queue.offer(new int[]{ball[0],ball[1]});
        while (!queue.isEmpty()){
            int [] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            for (int i=1;i<move.length;i++){
                StringBuilder distan = new StringBuilder(distance[row][col]);
                int newrow = row;
                int newcol = col;
                while (newrow>=0&&newcol>=0&&newcol<maze[0].length&&newrow<maze.length&&maze[newrow][newcol]!=1){
                    newrow += move[i][0];
                    newcol +=move[i][1];
                    if (i==1){
                        distan.append("r");
                    }else if (i==2) {
                        distan.append("l");
                    }else if (i==3) {
                        distan.append("d");
                    }else if (i==4) {
                        distan.append("u");
                    }
                }
                distan.deleteCharAt(distan.length()-1);
                if (num(distan.toString())<num(distance[newrow-move[i][0]][newcol-move[i][1]])){
                    queue.offer(new int[]{newrow-move[i][0],newcol-move[i][1]});
                    distance[newrow-move[i][0]][newcol-move[i][1]] = distan.toString();
                }
            }
        }
        return null;
    }

    public static int num (String s){
        int num = 0;
        for (int i=0;i<s.length();i++){
            num+=s.charAt(i);
        }
        return num;
    }
}
