package A_leetcode.hot75;

import java.util.Arrays;

public class No875 {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{312884470}, 312884469));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i = 0;i<piles.length;i++){
            max = Math.max(piles[i],max);
        }
        int min  = 0;
        int ans = max;
        while (min<=max){
            int mid = min + ((max-min)>>1);
            if (is(mid,piles,h)){
                ans = Math.min(mid,ans);
                max = mid-1;
            }else {
                min = mid+1;
            }
        }
        return ans;
    }


    public static boolean is(int num,int [] piles,int h){
        int cnts = 0;
        for (int i = 0;i<piles.length;i++){
            cnts += (piles[i]+num-1)/num;
            if ( cnts>h){
                return false;
            }
        }
        return true;
    }
}
