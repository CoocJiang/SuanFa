package 二分查找.二分答案法;

import java.util.PriorityQueue;

public class Code06_WaitingTime {
    // 计算等位时间
    // 给定一个数组arr长度为n，表示n个服务员，每服务一个人的时间
    // 给定一个正数m，表示有m个人等位，如果你是刚来的人，请问你需要等多久？
    // 假设m远远大于n，比如n <= 10^3, m <= 10^9，该怎么做是最优解？
    // 谷歌的面试，这个题连考了2个月
    // 找不到测试链接，所以用对数器验证

    public static int waitingTime2(int[] arr, int m) {
        int min = Integer.MAX_VALUE;
        for (int i = 0;i<arr.length;i++){
            min = Math.min(min,arr[i]);
        }
        int r = min*m;
        int l = 0;
        int ans = 0;
        while (l<=r){
            int mid = l+((r-l)>>1);
            if (f(mid,arr,m)){
                ans = mid;
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return ans;
    }

    public static boolean f(int mid,int [] arr,int m){
        int ans = 0;
        for (int num : arr) {
            ans += (mid / num) + 1;
        }
        return ans>m;
    }


    // 堆模拟
    // 验证方法，不是重点
    // 如果m很大，该方法会超时
    // 时间复杂度O(m * log(n))，额外空间复杂度O(n)
    public static int waitingTime1(int[] arr, int m) {
        // 一个一个对象int[]
        // [醒来时间，服务一个客人要多久]
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            heap.add(new int[] { 0, arr[i] });
        }
        for (int i = 0; i < m; i++) {
            int[] cur = heap.poll();
            cur[0] += cur[1];
            heap.add(cur);
        }
        return heap.peek()[0];
    }


    // 对数器测试
    public static void main(String[] args) {
        System.out.println("测试开始");
        int N = 50;
        int V = 30;
        int M = 3000;
        int testTime = 20000;
        for (int i = 0; i < testTime; i++) {
            int n = (int) (Math.random() * N) + 1;
            int[] arr = randomArray(n, V);
            int m = (int) (Math.random() * M);
            int ans1 = waitingTime1(arr, m);
            int ans2 = waitingTime2(arr, m);
            if (ans1 != ans2) {
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束");
    }

    // 对数器测试
    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * v) + 1;
        }
        return arr;
    }
}
