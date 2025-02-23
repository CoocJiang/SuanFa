package A_leetcode.leetcodeall;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No2208 {
    public static void main(String[] args) {
        int [] nums = {1,1};
        System.out.println(halveArray(nums));
    }
    public  static int halveArray(int[] nums) {
        PriorityQueue<Double> maxheap = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o2.compareTo(o1);
            }
        });
        double sum=0;
        for (int i = 0;i<nums.length;i++){
            maxheap.add(nums[i]/1.0);
            sum += nums[i];
        }
        int count = 0;
        double sum2 = 0;
        double cur = 0;
        sum = sum/2.0;
        while (sum2<sum){
            cur = maxheap.poll()/2.0;
            sum2 += cur;
            maxheap.add(cur);
            count++;
        }
        return count;
    }
}
