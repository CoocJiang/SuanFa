package 二分查找.二分答案法;

import java.util.Arrays;

public class No2141 {
    public static void main(String[] args) {
        System.out.println(maxRunTime(3, new int[]{10, 10, 3, 5}));
    }
    public  static long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        long min = Integer.MAX_VALUE;
        for(int i = 0 ;i<batteries.length;i++){
            sum +=batteries[i];
            min = Math.min(min,batteries[i]);
        }
        long l  = min;
        long r = sum;
        long ans = min;
        while(l<=r){
            long mid = l+((r-l)>>1);
            if(f(n,mid,batteries,sum)){
                ans = mid;
                l = mid+1;
            }else{
                r  = mid-1;
            }
        }
        return ans;
    }

    public static boolean f(int n,long mid ,int [] batteries,long sum){
        int length = batteries.length;
        for (int i:batteries){
            if (i>=mid){
                n--;
                sum-=i;
                length--;
            }
        }
        if(sum>=mid*n&&length>n){
            return true;
        }else{
            return false;
        }
    }
}
