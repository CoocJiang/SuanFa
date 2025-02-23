package b_b动态规划.暴力递归;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 咖啡机问题 {
    ////题目
    //// 数组arr代表每一个咖啡机冲一杯咖啡的时间,每个咖啡机只能串行的制造咖啡。
    //// 现在有n个人需要喝咖啡,只能用咖啡机来制造咖啡。
    //// 认为每个人喝咖啡的时间非常短,冲好的时间即是喝完的时间。
    ////每个人喝完之后咖啡杯可以选择洗或者自然挥发干净,只有一台洗咖啡杯的机器,只能串行的洗咖啡杯。
    ////洗杯子的机器洗完一个杯子时间为a,任何一个杯子自然挥发干净的时间为b。
    ////四个参数:arr, n,a, b
    //// 假设时间点从0开始,返回所有人喝完咖啡并洗完咖啡杯的全部过程结束后,至少来到什么时间点。
    static class coffee{
        int timepoint;
        int worktime;
        public coffee(int timepoint,int worktime){
            this.timepoint = timepoint;
            this.worktime = worktime;
        }
    }
    public static class myconpare implements Comparator<coffee>{
        @Override
        public int compare(coffee o1, coffee o2) {
            return (o1.timepoint+o1.worktime) - (o2.timepoint+o2.worktime);
        }
    }
    //先得到每个人喝完咖啡的最小时间
    public static  int minTime1(int []arr,int n ,int a, int b){
        PriorityQueue<coffee> minHeap = new PriorityQueue<>(new myconpare());
        for (int i=0;i<arr.length;i++){
            minHeap.add(new coffee(0,arr[i]));
        }
        int [] drink = new int[n];
        for (int i=0;i<n;i++){
            coffee cur  = minHeap.poll();
            cur.timepoint = cur.timepoint+ cur.worktime;
            minHeap.add(cur);
            drink[i] = cur.timepoint;
        }
        return minTime2(drink,0,0,a,b);
    }
    //传入之前得到的最小喝完的时间，现在生成，洗完的最小时间
    public static int minTime2(int [] drinks, int index, int free, int wash, int air){
        if (index >= drinks.length) {
            return 0;
        }

        int selfClean1 = drinks[index] + wash; // 自洁1时间
        int restClean1 = minTime2(drinks, wash, air, index + 1, selfClean1); // 剩余杯子的最小时间

        int selfClean2 = drinks[index] + air; // 自洁2时间
        int restClean2 = minTime2(drinks, wash, air, index + 1, free); // 剩余杯子的最小时间

        return Math.min(Math.max(selfClean1, restClean1), Math.max(selfClean2, restClean2));
    }

    public  static int Mintime(int [] drinks, int wash , int air){
        int washfree = drinks[0]+wash;
        int maxwash = washfree;
        for(int i = 1; i< drinks.length; i++){
            maxwash = maxwash+Math.max(drinks[i],washfree)+wash;
        }
        int [][] dp = new int [drinks.length+1][maxwash+1];
        for (int index = drinks.length-1; index>=0; index--){
            for (int free=0;free<maxwash;free++){

                //当前杯子使用mechien
                int selfclean1 = drinks[index]+wash;
                if (selfclean1>maxwash){
                    continue;
                }
                int restclean1 = dp[index+1][selfclean1];

                //当前杯子不用mechine
                int selfclean2 = drinks[index]+air;
                int restclean2 = dp[index+1][free];
                dp[index][free] =  Math.min(Math.max(selfclean1,restclean1),Math.max(selfclean2,restclean2));
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2};
        int n = 5;
        int a = 4;
        int b = 2;
        int result = minTime1(arr, n, a, b);
        System.out.println(result);
    }
}
