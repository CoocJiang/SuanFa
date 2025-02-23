package A_leetcode.leetcodeall;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No2956 {
    public static void main(String[] args) {
        for (int i = 0; i < findIntersectionValues(new int[]{2, 3, 2}, new int[]{1, 2}).length; i++) {
            System.out.println(i);
        }
    }
    public static int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int [] map1 = new int [101];
        int [] map2 = new int [101];

        for (int i = 0;i<nums1.length;i++){
            map1[nums1[i]]++;
        }
        int [] ans = new int[2];
        for (int i = 0;i<nums2.length;i++){
            map2[nums2[i]]++;
        }
        for (int i = 0;i<map1.length;i++){
            if (map1[i]!=0&&map2[i]!=0){
                ans[1]+=map2[i];
            }
        }
        for (int i = 0;i<map2.length;i++){
            if (map2[i]!=0&&map1[i]!=0){
                ans[0]+=map1[i];
            }
        }
        return ans;
    }
}
