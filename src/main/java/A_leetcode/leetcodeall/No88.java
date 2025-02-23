package A_leetcode.leetcodeall;

public class No88 {
    public static void main(String[] args) {
        merge(new int[]{1},1,new int[]{},0);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
       int [] arr = new int[m+n];
       int l = 0;
       int r = 0;
       int index = 0;
       while (l<m||r<n){
           if (l<m){
               if (r<n){
                   if (nums1[l]<=nums2[r]){
                       arr[index++] = nums1[l++];
                   }else {
                       arr[index++] = nums2[r++];
                   }
               }else {
                   arr[index++] = nums1[l++];
               }
           }else {
               arr[index++] = nums2[r++];
           }
       }
       for (int i = 0;i<nums1.length;i++){
           nums1[i] = arr[i];
       }
    }

    public static void swap(int[] nums1, int l, int[] nums2, int r){
        int temp = nums1[l];
        nums1[l] = nums2[r];
        nums2[r] = temp;
    }
}
