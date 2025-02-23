package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No475 {
    public static void main(String[] args) {
        System.out.println(findRadius(new int[]{1, 2, 3}, new int[]{2}));
    }

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int l  = 0;
        int r = 0;

        int ans = 0;
        while(l<houses.length){
            int radium = Math.abs(heaters[r]-houses[l]);
            int nradium = radium;
            if (r+1<heaters.length){
                nradium = Math.abs(heaters[r+1]-houses[l]);
                while(nradium<=radium){
                    radium = nradium;
                    if(r<heaters.length-1){
                        r++;
                    }
                    if(r+1<heaters.length){
                        nradium = Math.abs(heaters[r+1]-houses[l]);
                    }else {
                        break;
                    }
                }
            }
            l++;
            ans = Math.max(ans,radium);
        }
        return ans;
    }
}
   