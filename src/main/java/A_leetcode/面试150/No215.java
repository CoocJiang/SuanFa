package A_leetcode.面试150;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No215 {

    public static void main(String[] args) {
        System.out.println(heapsort1(new int[]{5,2,3,1}));
    }

    public static int findKthLargest(int[] nums, int k) {
        size=0;
        for (int i:nums){
            heapinsert(i);
        }
        for(int i=1;i<k;i++){
            poll();
        }
        return poll();
    }
    //记得自己手写大根堆实现

    //以下是自己的手写堆
    static int [] heap = new int [10000];

    static int size;

    static void swap(int a,int b){
        int temp = heap[a];
        heap[a]=heap[b];
        heap[b]=temp;
    }

    static void heapinsert(int a){
        //插入数字a
        int index = size;
        size++;
        heap[index] = a;
        int big = index;
        while (big>0){
            big = ((index-1)/2);
            //如果比自己的父亲大，就一直交换
            if (heap[big]<a){
                swap(big,index);
                index = big;
            }else {
                break;
            }
        }
    }

    //从头到尾调整堆
    static void heapify(){
        //插入数字a
        int index = 0;
        while (index>=0&&index<size){
            int big = index*2+1;
            if (big<size){
                if (big+1<size){
                    if (heap[big+1]>heap[big]){
                        big++;
                    }
                }
                if (heap[big]>heap[index]){
                    swap(big,index);
                    index=big;
                }else {
                    break;
                }
            }else {
                break;
            }
        }
    }

    //弹出堆顶元素
    static int poll(){
        int temp = heap[0];
        swap(0,--size);
        heapify();
        return temp;
    }


    //根据数组建堆,并且完成堆排序
    public static int [] heapsort1(int []nums){
        for (int i:nums){
            heapinsert(i);
        }

        for (int i=nums.length-1;i>=0;i--){
           nums[i] =  poll();
        }
        return nums;
    }



}
