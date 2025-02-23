package 排序;

import java.util.Arrays;
import java.util.HashSet;

public class BubullerSort {

    public static void main(String[] args) {
        int[] ints = {8, 2, 149, 11, 22, 44};
        shellsort(ints);
        for (int i :ints) {
            System.out.println(i);
        }
    }

    //shellsort
    public static void shellsort(int[] nums) {
        int n = nums.length;
        // 我们使用的生成函数是 2^(k-1)
        // 即 h = 1, 2, 4, 8, 16...
        int h = 1;
        while (h <n / 2) {
            h = 2 * h;
        }
        // 改动一，把归并排序的主要逻辑套在 h 的 while 循环中
        while (h >= 1) {
            // 改动二，sortedIndex 初始化为 h，而不是 1
            int sortedIndex = h;
            while (sortedIndex < n) {
                // 改动三，把比较和交换元素的步长设置为 h，而不是相邻元素
                for (int i = sortedIndex; i >= h; i -= h) {
                    if (nums[i] < nums[i - h]) {
                        // swap(nums[i], nums[i - h])
                        int tmp = nums[i];
                        nums[i] = nums[i - h];
                        nums[i - h] = tmp;
                    } else {
                        break;
                    }
                }
                sortedIndex++;
            }

            // 按照递增函数的规则，缩小 h
            h /= 2;
        }
    }
    //冒泡
    public static int [] bubull(int [] arr){
        boolean flag = true;
        for (int i = 1;i<arr.length;i++){
            if (arr[i-1]>arr[i]){
                flag = false;
                swap(i-1,i,arr);
            }
            if (flag){
                break;
            }
        }
        return arr;
    }

    //选择排序
    public static int [] selectsort(int [] arr){
        for (int i = 0;i<arr.length;i++){
            int min = i;
            for (int j = i+1;j<arr.length;j++){
                if (arr[j]<arr[min]){
                    min = j;
                }
            }
            swap(i,min,arr);
        }
        return arr;
    }


    //插入排序
    public static int [] insertSort(int [] arr){


        for (int i = 1; i < arr.length; i++) {

            // 记录要插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }

        }
        return arr;
    }



    //归并排序
    public static int [] mergeSort(int [] arr){
        if (arr.length<2){
            return arr;
        }else {
            int mid = arr.length/2;
            int []left = Arrays.copyOfRange(arr,0,mid);
            int [] right = Arrays.copyOfRange(arr,mid,arr.length);
            return merge(mergeSort(left),mergeSort(right));
        }
    }
    public static int [] merge(int [] left,int [] right) {
        int[] result = new int[right.length + left.length];
        int i = 0;
        int l = 0;
        int r = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                result[i++] = left[l++];
            } else {
                result[i++] = right[r++];
            }
        }
        while (l < left.length) {
            result[i++] = left[l++];
        }
        while (r < right.length) {
            result[i++] = right[r++];
        }
        return result;
    }

    //堆排序
    public static int [] buildheap(int []arr){
        for (int i = arr.length/2-1;i>=0;i--){
            heapify(arr,arr.length,i);
        }
        return arr;
    }
    public static int [] heapsort(int []arr){
        int n = arr.length;
        arr = buildheap(arr);
        for (int i = n-1;i>0;i--){
            swap(0,i,arr);
            heapify(arr,i,0);
        }
        return arr;
    }
    public static void heapify(int [] arr,int heapsize,int k){
        while (k<heapsize/2){
            int large = 2*k+1;
            int right = 2*k+2;
            if (right<heapsize && arr[right]>arr[large]){
                large = right;
            }
            if (arr[k]>arr[large]){
                break;
            }else {
                swap(large,k,arr);
                k = large;
            }
        }

    }

    //quikcSort
    public static void  quiksort(int [] arr){
        if (arr.length>1){
            partition(arr, 0,arr.length-1);
        }
    }
    private static void partition(int[] arr, int l, int r) {
        if (l>=r){
            return ;
        }
        // 设定基准值为开头
        int a = l+1;
        int b = l+1;
        while (b<=r){
            if (arr[b]<arr[l]){
                swap(a,b,arr);
                a++;
            }
            b++;
        }
        swap(l, a - 1,arr);
        partition(arr,l,a-2);
        partition(arr,a,r);
    }


    public static void swap(int a,int b,int [] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }
}
