package mt;

import java.util.PriorityQueue;

public class No215 {
    public static void main(String[] args) {

    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int I:nums){
            priorityQueue.add(I);
        }
        int num = 0;
        for (int i = 0;i<k;i++){
            num = priorityQueue.poll();
        }
        return num;
    }
}
