package A_leetcode.leetcodeall;

import java.util.List;

public class No315 {



    private static class Pair {
        int val, index;
        Pair(int val, int index) {
            // 记录数组的元素值
            this.val = val;
            // 记录元素在数组中的原始索引
            this.index = index;
        }
    }



//    static Pair[] pairs;
//    public static List<Integer> countSmaller(int[] nums) {
//        int n = nums.length;
//        pairs = new Pair[n];
//        int [] counts = new int[n];
//        for (int i = 0;i<nums.length;i++){
//            pairs[i] = new Pair(nums[i],i);
//        }
//        sort(nums,0,n-1);
//
//    }

//    private static void sort(int[] nums, int left, int right) {
//        if (left==right){
//            return;
//        }
//        int mid = left+((right-left)>>1);
//        sort(nums,left,mid);
//        sort(nums,mid+1,right);
//        merge(nums,left,mid,right);
//    }

//    private static void merge(int[] nums, int left, int mid, int right) {
//        int [] temp = new int[right-left+1];
//        for (int i = left,j=0;i<=right;i++){
//            temp[j++] = nums[i];
//        }
//        int l = left,r = mid+1,j = 0;
//        while (l<=mid||r<=right){
//            if (l==mid){
//                nums[r++] = temp[j++];
//            }else if (r==right){
//                nums[l++] = temp[j++];
//            }else if ()






//        }
//
//    }


}
