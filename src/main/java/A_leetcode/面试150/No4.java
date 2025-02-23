package A_leetcode.面试150;

import java.util.Arrays;

public class No4 {
    public static void main(String[] args) {
//        int [] nums = {1,3};
//        int [] nums2 = {2};
//        System.out.println(findMedianSortedArrays(nums, nums2));
    }



    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
      int [] arr = new int[nums1.length+nums2.length];
        System.arraycopy(nums1, 0, arr, 0, nums1.length);
        System.arraycopy(nums2, 0, arr, nums1.length, nums2.length);
        Arrays.sort(arr);
        if (arr.length%2==1){
            return   arr[arr.length/2];
        }else {
            int a = arr[arr.length/2];
            int b  = arr[arr.length/2-1];
            return (a+b)/2.0;
        }
    }

//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//      if (nums1.length>nums2.length){
//          int [] temp = nums2;
//          nums2 = nums1;
//          nums1 = temp;
//      }
//        int n = nums1.length;
//        int m = nums2.length;
//        int total = (n+m+1)/2;
//        int left = 0;
//        int right = n-1;
//        int mid1 = (left+right)/2;
//        //mid1+mid2 = (n+m+1)/2
//        int mid2 = total-mid1-1;
//        // nums1[mid1-1] > nums2[mid2] nums2[mid2-1] < nums1[mid1]
//        while (left<=right){
//
//        }
//        System.out.println(mid1);
//        System.out.println(mid2);
//        return 0.0;
//    }
}
