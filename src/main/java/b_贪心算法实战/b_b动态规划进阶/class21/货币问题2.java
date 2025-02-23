package b_贪心算法实战.b_b动态规划进阶.class21;

public class 货币问题2 {


    //题目改进每一种面值可以随便使用
    public static int coinsWay(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    public static int process1(int [] arr,int index,int rest){
        //basecase
        if (index == arr.length){
            return rest==0 ?  1:0;
        }
        //到当前位置有很多选择，一直可以选到rest<aim的最大值
        int sum = 0;
        for (int i=0 ;arr[index]*i<=rest;i++){
           sum=sum+ process1(arr,index+1,(rest-arr[index]*i));
        }
        return sum;
    }

    //动态规划优化
    public static int min3(int [] arr,int aim){
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int dp [][] = new int[arr.length+1][aim+1];
        dp[arr.length][0] = 1;
        for (int index = arr.length-1;index>=0;index--){
            for (int rest = 0;rest<=aim;rest++){
                int sum = 0;
                for (int i=0;arr[index]*i<=rest;i++){
                    sum += dp[index+1][rest-arr[index]*i];
                }
                dp[index][rest] = sum;
            }
        }
        return dp[0][aim];
    }
    // 动态规划再次优化
    public static int min4(int [] arr,int aim){
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int dp [][] = new int[arr.length+1][aim+1];
        dp[arr.length][0] = 1;
        for (int index = arr.length-1;index>=0;index--){
            for (int rest = 0;rest<=aim;rest++){
                int sum = 0;
                sum += dp[index + 1][rest] + (rest - arr[index] >= 0 ? dp[index][rest - arr[index]] : 0);
                dp[index][rest] = sum;
            }
        }
        return dp[0][aim];
    }


}
