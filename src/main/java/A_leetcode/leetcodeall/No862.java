package A_leetcode.leetcodeall;

public class No862 {
    public static void main(String[] args) {
        System.out.println(shortestSubarray(new int[]{84,-37,32,40,95}, 167));
    }
    static int MAXN = 100001;

    //双端队列里面维持的是一个从小到大的前缀和的值的索引
    static int [] deque = new int[MAXN];
    public static int shortestSubarray(int[] nums, int k) {
        int h  = 0;
        int t = 0;
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        //使用long类型，因为数值可能超过int的范围
        long sum = 0;
        long [] arr = new long [n+1];
        arr[0] = 0;
        deque[t++] = 0;
        //建立前缀和数组
        for(int i=0;i<n;i++){
            sum+=nums[i];
            arr[i+1] = sum;
        }
        for(int i = 1;i<n+1;i++){
            //来到i位置，如果减掉最小（负数也是一样的道理）的前缀和都无法满足，说明不存在
            while(h<t&&arr[i]-arr[deque[h]]>=k){
                ans = Math.min(ans,i-deque[h]);
                h++;
            }
            //每次往里面存入的都是到当前位置的前缀和
            while(t>h&&arr[i]<=arr[deque[t-1]]){
                t--;
            }
            deque[t++] = i;
        }
        return ans==Integer.MAX_VALUE ? -1:ans;
    }
}
