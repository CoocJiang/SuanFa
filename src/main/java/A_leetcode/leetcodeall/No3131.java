package A_leetcode.leetcodeall;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class No3131 {

    public static int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0]-nums1[0];
    }

}
