package A_leetcode.leetcodeall;

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.function.BiFunction;

public class bytedance006 {
    static int pre,cur,happy;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        int [] cost = new int[n+1];
        int []  val = new int[n+1];
        int ans = 0;
        int m = 1;
        for (int i = 0;i<n;i++){
            s = bf.readLine().split(" ");
            pre = Integer.parseInt(s[0]);
            cur = Integer.parseInt(s[1]);
            happy = Integer.parseInt(s[2]);
            int well = pre-cur-cur;
            if (well>=0){
                x+= well;
                ans += happy;
            }else {
                cost[m] = -well;
                val[m++] = happy;
            }
        }
        int [] dp = new int[x+1];
        for (int i = 1; i < m; i++) {
            for (int j = x; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + val[i]);
            }
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.print(dp[x]+ans);
        out.close();
    }
}
