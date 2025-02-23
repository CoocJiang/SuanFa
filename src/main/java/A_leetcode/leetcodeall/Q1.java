package A_leetcode.leetcodeall;

public class Q1 {

    static class neighborSum {

        int [][] grid;

        int [][] index;

        int length;
        public neighborSum(int[][] grid) {
            this.grid = grid;
            length = grid.length;
            index = new int[grid.length*grid.length][2];
            for (int i = 0;i<grid.length;i++){
                for (int j = 0;j<grid.length;j++){
                    index[grid[i][j]][0] = i;
                    index[grid[i][j]][1] = j;
                }
            }
        }

        public int adjacentSum(int value) {
            int sum = 0;
            if (index[value][0]>0){
                sum+=grid[index[value][0]-1][index[value][1]];
            }
            if (index[value][0]<(grid.length-1)){
                sum+=grid[index[value][0]+1][index[value][1]];
            }
            if (index[value][1]>0){
                sum+=grid[index[value][0]][index[value][1]-1];
            }
            if (index[value][1]<(grid.length-1)){
                sum+=grid[index[value][0]][index[value][1]+1];
            }
            return sum;
        }

        public int diagonalSum(int value) {
            int sum = 0;
            if (index[value][0]>0){
                if (index[value][1]>0){
                    sum+=grid[index[value][0]-1][index[value][1]-1];
                }
                if (index[value][1]<(length-1)){
                    sum+=grid[index[value][0]-1][index[value][1]+1];
                }
            }
            if (index[value][0]<(grid.length-1)){
                if (index[value][1]>0){
                    sum+=grid[index[value][0]+1][index[value][1]-1];
                }
                if (index[value][1]<(length-1)){
                    sum+=grid[index[value][0]+1][index[value][1]+1];
                }
            }
            return sum;
        }
    }
}
