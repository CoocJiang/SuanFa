package A_leetcode.leetcodeall;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class No3153 {
    public static void main(String[] args) {
        System.out.println(sumDigitDifferences(new int[]{13,23,12}));
    }
    public static long sumDigitDifferences(int[] nums) {
        long ans = 0;
        int [] cnt = new int[10];
        while (nums[0]>0){
            Arrays.fill(cnt,0);
            for (int i = 0;i<nums.length;i++){
                cnt[nums[i]%10]++;
                nums[i] /=  10;
            }
            long count = 0;
            for (int i  = 0;i<10;i++){
                if (cnt[i]>0){
                    for (int j = i+1;j<10;j++){
                        count+= (long) cnt[i] *cnt[j];
                    }
                }
            }
            ans+=count;
        }
        return ans;
    }

    public static int get(int a,int b){
        int count = 0;
        int f = a;
        int s = b;
        while (a>0){
            f = a%10;
            s = b%10;
            count+= f==s ? 0:1;
            a /= 10;
            b /= 10;
        }
        return Math.abs(count);
    }
}
