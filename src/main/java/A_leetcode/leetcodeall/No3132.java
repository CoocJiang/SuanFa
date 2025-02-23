package A_leetcode.leetcodeall;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class No3132 {

    public static void main(String[] args) {
        System.out.println(minimumAddedInteger(new int[]{6,3,6,7}, new int[]{6,2}));
    }
    static int [][] arr = new int[1000][3];
    public static int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l = 0;
        int r = 0;
        int n = nums2.length;
        while (l<n){
            r = l;
            int key = nums2[l]-nums1[r];
            arr[0][l] = key;
            for (int i = 1;i<3&&r+i<n+2;i++){
                key = nums2[l]-nums1[r+i];
                arr[i][l] = key;
            }
            l++;
        }
        int min = Integer.MAX_VALUE;
        int cur ;
        for (int high = 0;high<3;high++){
            cur = arr[high][0];
            int i = 1;
            int high1 = high;
            for (;i<n;){
                if (arr[high1][i] == cur){
                    cur = arr[high1][i];
                    i++;
                }else {
                    high1++;
                    if (high1>=3){
                        break;
                    }
                }
            }
            if (i==n){
                min = Math.min(min,cur);
            }
        }
        return min;
    }
}
