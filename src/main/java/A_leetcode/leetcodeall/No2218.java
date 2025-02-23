package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No2218 {
    public static void main(String[] args) {
        // 创建 List<List<Integer>>
        List<List<Integer>> piles = new ArrayList<>();

        piles.add(Arrays.asList(100));
        piles.add(Arrays.asList(100));
        piles.add(Arrays.asList(100));
        piles.add(Arrays.asList(100));
        piles.add(Arrays.asList(100));
        piles.add(Arrays.asList(100));
        piles.add(Arrays.asList(1, 1, 1, 1, 1, 1, 700));
        System.out.println(maxValueOfCoins(piles, 7));
    }
    static List<Integer> cur;
    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int [][] dp = new int[n+1][k+1];
        int max = 0;
        for (int i = 0;i<n;i++){
            max = Math.max(max,piles.get(i).size());
        }
        int [][] presum = new int[n][max+1];
        for (int i = 0;i<n;i++){
            int sum = 0;
            for (int j = 0;j<piles.get(i).size();j++){
                sum+=piles.get(i).get(j);
                presum[i][j] = sum;
            }
        }
        for (int i = 1;i<=n;i++){
            cur = piles.get(i-1);
            for (int j = 0;j<=k;j++){
                //来到第i个栈，1.这个栈一个也不拿，
                dp[i][j] = dp[i-1][j];
                //2.这个栈拿1...Math.min()个
                int min = Math.min(cur.size(),j);
                for (int l = 0;l<min;l++){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-l-1]+presum[i-1][l]);
                }
            }
        }
        return dp[n][k];
    }
}
