package NowCoder;
import java.io.*;
import java.util.Arrays;

public class 二叉树 {
    static int MOD = 1000000007;
    static int [][] dp;
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        // 注意 hasNext 和 hasNextLine 的区别
        String [] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        dp = new int [n+1][m+1];
        for (int i = 0;i<=m;i++){
            dp[0][i] = 1;
        }
        for (int row = 1;row<n+1;row++){
            for (int col = 1;col<m+1;col++){
                long ans = 0;
                for (int k = 0; k < n+1; k++) {
                    if(row-k-1<0){
                        break;
                    }
                    ans = (ans + ((long) dp[k][col - 1] * dp[row - k - 1][ col - 1]) % MOD) % MOD;
                }
                dp[row][col] = (int) ans;
            }
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.print(dp[n][m]);
        out.close();
    }
    /**返回高度为m，节点数为n的二叉树有多少种 */
    public static int process(int n,int m){
        //如果此时不剩下节点，说明得到一种
        if(n==0){
            return 1;
        }
        if(m==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        long ans = 0;
        // n个点，头占掉1个
        for (int k = 0; k < n; k++) {
            // 一共n个节点，头节点已经占用了1个名额
            // 如果左树占用k个，那么右树就占用i-k-1个
            ans = (ans + ((long) process(k, m - 1) * process(n - k - 1, m - 1)) % MOD) % MOD;
        }
        dp[n][m] =(int) ans;
        return  (int) ans;
    }
}
