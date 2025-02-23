package b_贪心算法实战.b_b动态规划进阶.class23;

import jdk.nashorn.internal.ir.SplitReturn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class code02_zj {

    public static void main(String[] args) {
        // 测试数组
        int[] arr = {5,22,13,20,29,8,20,42};
        HashMap<Integer,Integer> map = new HashMap<>();

        // 调用你提供的方法
        int result = right2(arr);

        // 输出结果
        System.out.println("分割后两部分和的最大值为：" + result);
    }
    public static int right2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if ((arr.length & 1) == 0) {
            return process2(arr, 0, arr.length / 2, sum / 2);
        } else {
            return Math.max(process2(arr, 0, arr.length / 2, sum / 2), process2(arr, 0, arr.length / 2 + 1, sum / 2));
        }
    }

    private static int process2(int[] arr, int index, int picks, int rest) {

        //如果需要挑选的数大于剩余的数字，那么不可能实现
        if (picks> (arr.length-index)){
            return -1;
        }else if (index== arr.length){
            return picks == 0 ? 0:-1;
        }
        {
            //当前有两种情况，选当前数字或者不选
            int p1 = 0;
            int next = 0;
            if (rest-arr[index]>=0){
                next = process2(arr,index+1,picks-1,rest-arr[index]);
                if (next==0){
                    p1 = -1;
                }else {
                    p1 = arr[index]+next;
                }
            }
            //不选
            int p2 = process2(arr,index+1,picks,rest);
            return Math.max(p1,p2);
        }
    }
}
