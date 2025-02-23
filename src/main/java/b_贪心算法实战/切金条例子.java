package b_贪心算法实战;

import java.util.PriorityQueue;

public class 切金条例子 {
    public static void main(String[] args) {
        // 测试用例
        int[] arr1 = {10, 20, 30};
        int[] arr2 = {30, 20, 10};
        int[] arr3 = {10, 30, 5, 20};

        // 调用算法进行测试
        System.out.println(lessmoney(arr1)); // 90
        System.out.println(lessmoney(arr2)); // 90
        System.out.println(lessmoney(arr3)); // 115
        System.out.println(less2(0,arr1));
    }
    public static int lessmoney(int arr[]){
        int ans = 0;
        int cur = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i:arr){
            minHeap.add(i);
        }
        while(minHeap.size()!=0){
            cur = minHeap.poll()+minHeap.poll();
            minHeap.add(cur);
            ans = cur+ans;
            if (minHeap.size()==1){
                break;
            }
        }
        return ans;
    }
    //对数器,没写对
    public static int less2(int pre,int [] arr){
        if (arr.length==1){
            return pre;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0;i< arr.length;i++){
            for (int j = i+1;j< arr.length;j++){
                ans = Math.min(ans,pre+less2(pre+arr[i]+arr[j],mergeAndRemove(arr,i,j)));
            }
        }
        return pre;
    }
    public static int[] mergeAndRemove(int[] arr, int left, int right) {
        // 创建新数组，长度为原数组减去一个元素
        int[] newArr = new int[arr.length - 1];

        // 将 right 处的值加到 left 处
        arr[left] += arr[right];

        // 复制除了 right 处的值以外的所有元素到新数组
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != right) {
                newArr[j++] = arr[i];
            }
        }

        // 返回新数组
        return newArr;
    }

}
