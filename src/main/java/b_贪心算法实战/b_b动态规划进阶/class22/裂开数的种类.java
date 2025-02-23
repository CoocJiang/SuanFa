package b_贪心算法实战.b_b动态规划进阶.class22;

public class 裂开数的种类 {
    public static void main(String[] args) {
        int test = 20;
        System.out.println(ways(test));
        System.out.println(ways2(test));
        System.out.println(dp1(test));
    }
    public static int ways(int n){
        if (n==1){
            return 1;
        }
        return process1(1,n);
    }

    public static int process1(int pre,int rest){
        //basecase
        if (rest==0){
            return 1;
        }
        //
        int ways = 0;
        for(int i = pre;i<=rest;i++){
            ways += process1(i,rest-i);
        }
        return ways;
    }
    public static int ways2 (int n){
        int [][]  dp = new int[n+1][n+1];
        for (int i=1;i<n+1;i++){
            dp[i][i] = 1;
        }
        for (int i = 1;i<=n;i++){
            dp[i][0]=1;
        }
       for (int pre = n-1;pre>=1;pre--){
           for (int rest = pre+1;rest<=n;rest++){
               dp[pre][rest]=dp[pre+1][rest]+dp[pre][rest-pre];
           }
       }
        return dp[1][n];
    }

    public static int dp1(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int pre = 1; pre <= n; pre++) {
            dp[pre][0] = 1;
            dp[pre][pre] = 1;
        }
        for (int pre = n - 1; pre >= 1; pre--) {
            for (int rest = pre+1; rest <= n; rest++) {
                int ways = 0;
                for (int first = pre; first <= rest; first++) {
                    ways += dp[first][rest - first];
                }
                dp[pre][rest] = ways;
            }
        }
        return dp[1][n];
    }

}
