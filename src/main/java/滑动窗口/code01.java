package 滑动窗口;

import java.util.Deque;
import java.util.LinkedList;

public class code01 {
    public static void main(String[] args) {

    }
    //数组arr，滑动窗口大小w
    public static int[] getMaxWindow2(int[] arr, int w){
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        Deque<Integer> qmax = new LinkedList<>();
        int length = arr.length;
        int [] ans = new int[arr.length-w+1];
        qmax.add(0);
        //在双端队列长度到达w之前
        for (int i=1;i<w;i++){
            while (!qmax.isEmpty()&&arr[i]>=arr[qmax.peekLast()]){
                qmax.removeLast();
            }
            qmax.addLast(i);
        }
        //第一个位置的数为最大值
        ans[0] = arr[qmax.peekFirst()];
        //双端队列长度到大w之后
        for (int i=w;i<length;i++){
            //窗口往左移动，把前面的数字移出去
            while (!qmax.isEmpty()&&qmax.peekFirst()<i-w+1){
                qmax.removeFirst();
            }
            while (qmax.peekLast()!=null&&arr[i]>=arr[qmax.peekLast()]){
                qmax.removeLast();
            }
            qmax.addLast(i);
            ans[i-w+1]= arr[qmax.getFirst()];
        }
        return ans;
    }


}
