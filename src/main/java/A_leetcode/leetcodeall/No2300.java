package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No2300 {

    public static void main(String[] args) {
        for (int i : successfulPairs(new int[]{3,1,2}, new int[]{8,5,8}, 16)) {
            System.out.println(i);
        }
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int  [] ans = new int [spells.length];
        for(int i = 0;i<spells.length;i++){
            long target = (success - 1) / spells[i];
            if (target>potions[potions.length-1]){
                ans[i]=0;
                continue;
            }
            int l = 0;
            int r = potions.length-1;
            int mid = 0;
            while(l<=r){
                mid = (l+r) >>> 1;
                if (potions[mid]>target){
                    r = mid-1;
                }else {
                    l = mid+1;
                }
            }
            ans [i] = potions.length-r-1;
        }
        return ans;
    }
}


