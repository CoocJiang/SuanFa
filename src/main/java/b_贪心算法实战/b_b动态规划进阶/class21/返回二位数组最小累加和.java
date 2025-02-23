package b_贪心算法实战.b_b动态规划进阶.class21;

public class 返回二位数组最小累加和 {


    public static int min(int [] [] arr){
        int dp [][] = new int[arr.length][arr[0].length];
       dp[arr.length-1][arr[0].length-1] = arr[arr.length-1][arr[0].length-1];
       //最后一行之依赖右边，所以我们单独拿出来解决
        for (int j=arr[0].length-2;j>=0;j--){
            dp[arr.length-1][j] = arr[arr.length-1][j]+arr[arr.length-1][j+1];
        }
        //最后一列同理
        for (int j=arr.length-2;j>=0;j--){
            dp[j][arr[0].length-1] = arr[j][arr[0].length-1]+arr[j+1][arr[0].length-1];
        }
        for(int i= arr.length-2;i>=0;i--){
            for (int j=arr[0].length-2;j>=0;j--){
                dp[i][j] = arr[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }

    //空间优化

    public static int min2(int [] [] arr){
        int dp [] = new int[arr[0].length];
        dp[arr[0].length-1] = arr[arr.length-1][arr[0].length-1];
        //最后一行之依赖右边，所以我们单独拿出来解决
        for (int j=arr[0].length-2;j>=0;j--){
            dp[j] = arr[arr.length-1][j]+dp[j+1];
        }
        for(int i= arr.length-2;i>=0;i--){
            for (int j=arr[0].length-1;j>=0;j--){
                if (j==arr[0].length-1){
                    dp[j] = arr[i][j]+dp[j];
                }
                dp[j] = arr[i][j]+Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }
}
