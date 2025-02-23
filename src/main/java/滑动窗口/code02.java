package 滑动窗口;

import java.util.*;

public class code02 {

    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Set<Map.Entry<Integer, Integer>> entries1 = map.entrySet();

        for ( Map.Entry<Integer, Integer> entries:map.entrySet());
    }
    public static int num2(int[] arr, int sum){
        if (arr == null || arr.length == 0 || sum < 0) {
            return 0;
        }
        Deque<Integer> mindeque = new LinkedList<>();
        Deque<Integer> maxdeque = new LinkedList<>();
        mindeque.addLast(0);
        maxdeque.addLast(0);
        int counts = 0;
        int left = 0;
        int right = 1;
        //当右边窗口小于数组长度并且左窗口小于右窗口
        while (right<arr.length&&left<=right){
            //更新大值双端队列的最大值
            while (!mindeque.isEmpty()&&mindeque.peekFirst()<left){
                mindeque.pollFirst();
            }
            //更新小值双端队列的最小值
            while (!maxdeque.isEmpty()&&maxdeque.peekFirst()<left){
                maxdeque.pollFirst();
            }
            while (!maxdeque.isEmpty()&&arr[right]>=arr[maxdeque.peekLast()]){
                maxdeque.pollLast();
            }
            maxdeque.addLast(right);
            while (!mindeque.isEmpty()&&arr[right]<=arr[mindeque.peekLast()]){
                mindeque.pollLast();
            }
            mindeque.addLast(right);
            if (arr[maxdeque.peekFirst()]-arr[mindeque.peekFirst()]<=sum){
                right++;
            }else {
                left++;
                counts+=right-left;
            }
        }
        counts+=(right-left)*(right-left)/2;
        return counts;
    }

}
