package A_leetcode.leetcodeall;

import java.util.*;

public class No347 {

    public static void main(String[] args) {
        for (int i : topKFrequent(new int[]{1,2}, 2)) {
            System.out.println(i);
        }
    }


   static class ans {
        int val;
        int num;
        public ans(int num,int val){
            this.num = num;
            this.val = val;
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<ans> heap = new PriorityQueue<>(new Comparator<ans>() {
            @Override
            public int compare(ans o1, ans o2) {
                return o1.val-o2.val;
            }
        });
        Arrays.sort(nums);
        int shang = nums[0];
        int sum = 0;
        for (int i=0;i<= nums.length;i++ ){
            if(i<nums.length&&shang==nums[i]){
                sum++;
            }else {
                if (heap.size()<k){
                    heap.add(new ans(shang,sum));
                }else {
                    if (sum>heap.peek().val){
                        heap.poll();
                        heap.add(new ans(shang,sum));
                    }
                }
                sum = 1;
                if (i <nums.length){
                    shang = nums[i];
                }
            }
        }
        int[] intArray = new int[heap.size()];
        int index = 0;
       while (!heap.isEmpty()){
           intArray[index++] = heap.poll().num;
       }
        return intArray;
    }
}
