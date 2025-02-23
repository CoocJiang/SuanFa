package A_leetcode.面试150;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 合并两个有序数组 {
    public static void main(String[] args) {
        int nums [] = {1,2,3,0,0,0};
        int nums2 [] = {2,5,6};
        int m =3;
        int n =3;
        System.arraycopy(nums2,0,nums,m,n);
        Arrays.sort(nums);
        for (int i : nums){
            System.out.println(i);
        }
    }
}
