package A_leetcode.leetcodeall;

import java.util.LinkedList;
import java.util.Queue;

public class no1162 {


    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int max = -1;
        boolean [][] gridflag = new boolean[grid.length][grid[0].length];

        Queue<int []> queue = new LinkedList<>();
        //把所有的陆地加入到队列中来
        for (int r = 0;r< n;r++){
            for (int c=0;c<n;c++){
                if (grid[r][c]==1){
                    queue.offer(new int[]{r,c});
                    gridflag[r][c]=true;
                }
            }
        }
        int size = queue.size();
        if (queue.isEmpty()){
            return -1;
        }
        int level = 0;
        //bfs遍历
        while (!queue.isEmpty()){
            level++;
            int size1 = size;
            size=0;
            while (size1>0){
                int [] cur = queue.poll();
                size1--;
                int r = cur[0];
                int c = cur[1];
                //先处理边界情况
                if (cur[0]==n-1){
                    if (cur[1]==n-1){
                        //只能往左和上扩
                        if (!gridflag[r - 1][c]){
                            queue.offer(new int[]{r-1,c});
                            gridflag[r-1][c] = true;
                            size++;
                        }
                        if (!gridflag[r][c - 1]){
                            queue.offer(new int[]{r,c-1});
                            gridflag[r][c-1] = true;
                            size++;
                        }
                    }else if (cur[1]==0){
                        //只能往右和下扩
                        if (!gridflag[r - 1][c]){
                            queue.offer(new int[]{r-1,c});
                            gridflag[r-1][c] = true;
                            size++;
                        }
                        if (!gridflag[r][c + 1]){
                            queue.offer(new int[]{r,c+1});
                            gridflag[r][c+1] = true;
                            size++;
                        }
                    }else {
                        //上左右
                        if (!gridflag[r - 1][c]){
                            queue.offer(new int[]{r-1,c});
                            gridflag[r-1][c] = true;
                            size++;
                        }
                        if (!gridflag[r][c-1]){
                            queue.offer(new int[]{r,c-1});
                            gridflag[r][c-1] = true;
                            size++;
                        }
                        if (!gridflag[r][c+1]){
                            queue.offer(new int[]{r,c+1});
                            gridflag[r][c+1] = true;
                            size++;
                        }
                    }
                }else if (cur[0]==0){
                    if (cur[1]==n-1){
                        //只能往左和下扩
                        if (!gridflag[r + 1][c]){
                            queue.offer(new int[]{r+1,c});
                            gridflag[r+1][c] = true;
                            size++;
                        }
                        if (!gridflag[r][c - 1]){
                            queue.offer(new int[]{r,c-1});
                            gridflag[r][c-1] = true;
                            size++;
                        }
                    }else if (cur[1]==0){
                        //只能往xia和右扩
                        if (!gridflag[r + 1][c]){
                            queue.offer(new int[]{r+1,c});
                            gridflag[r+1][c] = true;
                            size++;
                        }
                        if (!gridflag[r][c + 1]){
                            queue.offer(new int[]{r,c+1});
                            gridflag[r][c+1] = true;
                            size++;
                        }
                    }else {
                        //下左右
                        if (!gridflag[r][c-1]){
                            queue.offer(new int[]{r,c-1});
                            gridflag[r][c-1] = true;
                            size++;
                        }
                        if (!gridflag[r+1][c]){
                            queue.offer(new int[]{r+1,c});
                            gridflag[r+1][c] = true;
                            size++;
                        }
                        if (!gridflag[r][c+1]){
                            queue.offer(new int[]{r,c+1});
                            gridflag[r][c+1] = true;
                            size++;
                        }
                    }
                }else {
                    if (cur[1]==n-1){
                            //上下左
                        if (!gridflag[r][c-1]){
                            queue.offer(new int[]{r,c-1});
                            gridflag[r][c-1] = true;
                            size++;
                        }
                        if (!gridflag[r+1][c]){
                            queue.offer(new int[]{r+1,c});
                            gridflag[r+1][c] = true;
                            size++;
                        }
                        if (!gridflag[r-1][c]){
                            queue.offer(new int[]{r-1,c});
                            gridflag[r-1][c] = true;
                            size++;
                        }
                    }else if (cur[1]==0){
                        if (!gridflag[r][c+1]){
                            queue.offer(new int[]{r,c+1});
                            gridflag[r][c+1] = true;
                            size++;
                        }
                        if (!gridflag[r+1][c]){
                            queue.offer(new int[]{r+1,c});
                            gridflag[r+1][c] = true;
                            size++;
                        }
                        if (!gridflag[r-1][c]){
                            queue.offer(new int[]{r-1,c});
                            gridflag[r-1][c] = true;
                            size++;
                        }
                    }else {
                        //上左右
                        if (!gridflag[r - 1][c]){
                            queue.offer(new int[]{r-1,c});
                            gridflag[r-1][c] = true;
                            size++;
                        }
                        if (!gridflag[r][c-1]){
                            queue.offer(new int[]{r,c-1});
                            gridflag[r][c-1] = true;
                            size++;
                        }
                        if (!gridflag[r+1][c]){
                            queue.offer(new int[]{r+1,c});
                            gridflag[r+1][c] = true;
                            size++;
                        }
                        if (!gridflag[r][c+1]){
                            queue.offer(new int[]{r,c+1});
                            gridflag[r][c+1] = true;
                            size++;
                        }
                    }
                }
            }
        }


        return level-1;
    }
}
