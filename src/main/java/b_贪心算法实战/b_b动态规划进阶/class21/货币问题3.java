package b_贪心算法实战.b_b动态规划进阶.class21;

import java.util.HashMap;
import java.util.Map;

public class 货币问题3 {

    public static class Info {
        public int[] coins;
        public int[] zhangs;

        public Info(int[] c, int[] z) {
            coins = c;
            zhangs = z;
        }
    }

    public static Info getInfo(int[] arr) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int value : arr) {
            if (!counts.containsKey(value)) {
                counts.put(value, 1);
            } else {
                counts.put(value, counts.get(value) + 1);
            }
        }
        int N = counts.size();
        int[] coins = new int[N];
        int[] zhangs = new int[N];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            coins[index] = entry.getKey();
            zhangs[index++] = entry.getValue();
        }
        return new Info(coins, zhangs);
    }

    public static int coinsWay2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        Info info = getInfo(arr);
        return process2(info.coins, info.zhangs, 0, aim);
    }

    public static int process2(int [] coins,int [] zhangs,int index,int rest){
        if (index == coins.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0;zhang<=zhangs[index]&&zhang*coins[index]<=rest;zhang++){
            ways += process2(coins,zhangs,index+1,rest-zhang*coins[index]);
        }
        return ways;
    }

    //有点难
    public static int dp3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
       Info info = getInfo(arr);
        int[] zhangs = info.zhangs;
        ;
        int[] coins = info.coins;
        int[][] dp = new int[coins.length + 1][aim + 1];
        dp[coins.length][0] = 1;
        for (int index = coins.length - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - coins[index] >= 0) {
                    dp[index][rest] += dp[index][rest - coins[index]];
                    if ((zhangs[index] + 1) * coins[index] <= rest) {
                        dp[index][rest] -= dp[index + 1][rest - coins[index] * (zhangs[index] + 1)];
                    }
                }
            }
        }
        return dp[0][aim];
    }





}
