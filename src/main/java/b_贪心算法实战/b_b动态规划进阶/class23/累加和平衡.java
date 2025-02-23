package b_贪心算法实战.b_b动态规划进阶.class23;

public class 累加和平衡 {
    public static void main(String[] args) {
        // 测试数组
        int[] arr = {3, 7, 4, 6, 5};

        // 调用你提供的方法
        int result = right(arr);

        // 输出结果
        System.out.println("分割后两部分和的最大值为：" + result);
    }

    public static int right(int[] arr){
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return process1(arr,0,sum>>1);
    }

    public static int process1(int []arr,int index,int rest){
        if (index==arr.length){
            return 0;
        }
        //当前数字，有两种情况，要不或者不要
        int p1= 0;
        if (rest-arr[index]>=0){
            p1 = arr[index] + process1(arr,index+1,rest-arr[index]);
        }
        int p2 =  process1(arr,index+1,rest);
        return Math.max(p1,p2);
    }


    public static int right2(int [] arr){
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        int border = sum/2;
        int dp[][] = new int [arr.length+1][border+1];
        for (int index = dp.length-2;index>= 0;index--){
            for (int rest = 0;rest<border+1;rest++){
                int p1= 0;
                if (rest-arr[index]>=0){
                    p1 = arr[index] + dp[index+1][rest-arr[index]];
                }
                int p2 = dp[index+1][rest];
                dp[index][rest] = Math.max(p1,p2);
            }
        }
        return  dp[0][border];


    }


}
