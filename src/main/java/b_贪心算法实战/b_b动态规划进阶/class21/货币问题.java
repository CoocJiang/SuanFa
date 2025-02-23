package b_贪心算法实战.b_b动态规划进阶.class21;

public class 货币问题 {
    //arr是货币数组,其中的值都是正数。再给定一个正数aim。
    //每个值都认为是一张货币,
    //即便是值相同的货币也认为每一张都是不同的,
    //返回组成aim的方法数
    //例如:arr={1,1,1}, aim=2
    //第0个和第1个能组成2,第1个和第2个能组成2,第0个和第2个能组成2
    //一共就3种方法,所以返回3

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5} ;
        int aim = 10;
        System.out.println(min2(arr,10));
    }

    public static int min(int [] arr,int aim){
        return process1(arr,0,aim);
    }

    public static int process1(int [] arr,int index,int rest){
        if (rest<0){
            return 0;
        }
        //basecase
        if (index == arr.length){
            return rest==0 ?  1:0;
        }
        //到当前位置只有两种选择，要当前货币或者不要
        return process1(arr,index+1,rest-arr[index])+ process1(arr,index+1,rest);
    }

    public static int min2(int [] arr,int aim){
        int dp [][] = new int[arr.length+1][aim+1];
        dp[arr.length][0] = 1;
        for (int i= arr.length-1;i>=0;i--){
            for (int j = 0;j<=aim;j++){
                if ((j-arr[i])<0){
                    dp[i][j] = dp[i + 1][j];
                }else {
                    dp[i][j] = dp[i + 1][j] + dp[i + 1][j - arr[i]];
                }
            }
        }
        return dp[0][aim];
    }



}
