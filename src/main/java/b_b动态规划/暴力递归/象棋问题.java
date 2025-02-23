package b_b动态规划.暴力递归;

public class 象棋问题 {
    //题目二
    //请同学们自行搜索或者想象一个象棋的棋盘，
    //然后把整个棋盘放入第一象限，棋盘的最左下角是（0.0）位置那么整个棋盘就是横坐标上9条线、纵坐标上10条线的区域给你三个 参数×，y，k
    //返回“马”从（0.0）位置出发，必须走k步最后落在（x.y）上的方法数有多少种？

    public static void main(String[] args) {
        // 测试案例
        System.out.println("Case 1: " + ans(5, 5, 6)); // 马只能走一步的情况
        System.out.println("Case 2: " + ans(7, 7, 10)); // 马需要两步才能到达目标位置的情况
        System.out.println("Case 3: " + ans(0, 0, 0)); // 目标位置就是起始位置的情况
    }
    static class Counter {
        int count;
    }

    public static int ans(int x, int y, int k) {
        Counter counter = new Counter();
        int [][][]dp = new int[10][9][k+1];
        for (int i = 0;i<10;i++){
            for (int j = 0;j<9;j++){
                for (int q = 0;q<k+1;q++){
                    dp[i][j][q] = -1;
                }
            }
        }
        process1(x,y,k,dp);
        return dp[x][y][k];
    }

    private static int process1(int x, int y, int k,int dp[][][]) {
        if (x < 0 || x > 9 || y > 8 || y < 0 || k < 0) {
            return 0;
        }
        if (dp[x][y][k]!=-1){
            return dp[x][y][k];
        }
        if (x == 0 && y == 0 && k == 0) {
            return 1;
        }
        int ans = 0;
        ans = ans+process1(x - 2, y + 1, k - 1,dp);
        ans = ans+process1(x - 1, y + 2, k - 1,dp);
        ans = ans+process1(x + 2, y + 1, k - 1,dp);
        ans = ans+process1(x + 1, y + 2, k - 1,dp);
        ans = ans+process1(x - 2, y - 1, k - 1,dp);
        ans = ans+process1(x - 1, y - 2, k - 1,dp);
        ans = ans+process1(x + 2, y - 1, k - 1,dp);
        ans = ans+process1(x + 1, y - 2, k - 1,dp);
        dp[x][y][k] = ans;
        return ans;
    }

    //动态规划优化
    public static int ans2(int x, int y, int k) {
        Counter counter = new Counter();
        int [][][]dp = new int[10][9][k+1];
        dp[x][y][0] = 1;
        for (int i=1;i<k+1;i++){
//           dp[][][i] = dp[][][i-1]

        }
        process1(x,y,k,dp);
        return dp[x][y][k];
    }
}
