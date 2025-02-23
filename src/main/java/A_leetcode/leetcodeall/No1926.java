package A_leetcode.leetcodeall;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No1926 {

    public static void main(String[] args) {
        char[][] maze = {
                {'+', '.', '+', '+', '+', '+', '+'},
                {'+', '.', '+', '.', '.', '.', '+'},
                {'+', '.', '+', '.', '+', '.', '+'},
                {'+', '.', '.', '.', '+', '.', '+'},
                {'+', '+', '+', '+', '+', '.', '+'}
        };


        System.out.println(nearestExit1(maze, new int[]{0, 1}));
    }



    public static int [] bu = {1,0,-1,0,1};
    static int [][] queue = new int[10001][2];
    public static int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        Arrays.fill(queue,new int[]{0,0});


        int left = 0;
        int right = 0;
        queue[right++] = entrance;
        maze[entrance[0]][entrance[1]] = '+';

        int ans = 0;
        boolean flag = false;
        int size1 = 1;
        int size2 = 0;
        while (left!=right){

            int [] cur = queue[left++];
            int x = cur[0];
            int y = cur[1];

            for (int i =  0;i<bu.length-1;i++){
                int nx = x+bu[i];
                int ny = y+bu[i+1];
                if (nx>=0&&nx<n&&ny>=0&&ny<m&&maze[nx][ny]=='.'){
                    maze[nx][ny] = '+';
                    if (nx==0||ny==0||nx==n-1||ny==m-1){
                        return ans+1;
                    }
                    queue[right++] = new int[]{nx,ny};
                    if (!flag){
                        size2++;
                    }else {
                        size1++;
                    }
                }
            }
            if (!flag){
                if (--size1==0){
                    ans++;
                    flag = !flag;
                }
            }else {
                if (--size2==0){
                    ans++;
                    flag = !flag;
                }
            }
        }
        return  -1;
    }


    public static int nearestExit1(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        Queue<int []> queue = new ArrayDeque<>();
        queue.clear();
        queue.add(entrance);
        int ans = 0;
        boolean flag = false;
        int size1 = 1;
        int size2 = 0;
        while (!queue.isEmpty()){

            int [] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];


            for (int i =  0;i<bu.length-1;i++){
                int nx = x+bu[i];
                int ny = y+bu[i+1];
                if (nx>=0&&nx<n&&ny>=0&&ny<m&&maze[nx][ny]=='.'){
                    maze[nx][ny] = '+';
                    if (nx==0||ny==0||nx==n-1||ny==m-1){
                        return ans+1;
                    }
                    queue.add(new int[]{nx,ny});
                    if (!flag){
                        size2++;
                    }else {
                        size1++;
                    }
                }
            }
            if (!flag){
                if (--size1==0){
                    ans++;
                    flag = !flag;
                }
            }else {
                if (--size2==0){
                    ans++;
                    flag = !flag;
                }
            }
        }
        return  -1;
    }
}
