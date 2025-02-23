package A_leetcode.Leetcode.msb算法.堆;

public class heap {
    public static void main(String[] args) {
//        int[] arr = {5, 3, 8, 4, 2, 1, 6,4};
//        heapSort(arr);
//        for (int n : arr) {
//            System.out.print(n + " ");
//        }
        int[] arr2 = {3,4,1,2,6,5,8,7};
        heapSort(arr2);
        for (int n : arr2) {
            System.out.print(n + " ");
        }
    }
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
////         建立初始堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
//        for (int i = arr.length-1;i>=0;i--){
//            heapify(arr,i,arr.length);
//        }

        int heapSize = arr.length;
        // 不断调整堆并交换堆顶元素与末尾元素
        while (heapSize > 1) {
            swap(0, heapSize - 1, arr);
            heapSize--;
            heapify(arr, 0, heapSize);
        }
    }
    public static void heapSort2(int[] arr,int k){
        int max=0;
        for (int i =0;i<arr.length-k;i++){
            heapInsert2(arr,i-1+k,i) ;
            max = i-1+k;
        }
        for (int i=max-1;i<arr.length;i++){
            heapInsert2(arr,i,max);
        }
    }
    public static void heapInsert2(int []arr,int index,int begin){
        if(index ==0 ){
            return;
        }
        while(arr[index]<arr[(index-1)/2]&&(index-1)/2>=begin){
            swap(index,((index-1)/2),arr);
            index = (index-1)/2;
        }
    }

    public static void heapInsert(int []arr,int index){
        if(index ==0 ){
            return;
        }
        while(arr[index]>arr[(index-1)/2]){
            swap(index,((index-1)/2),arr);
            index = (index-1)/2;
        }
    }
    public static void heapify(int[] arr,int index,int heapsize){
        if (heapsize < 2){
            return;
        }
        while (index*2+1<heapsize){
          int largest = index*2+1;
          if (largest+1<heapsize&&arr[largest]<arr[largest+1]){
              largest++;
            }
          if (arr[index]<arr[largest]){
              swap(largest,index,arr);
              index = largest;
          }else{
              break;
          }
        }
    }
    public  static void swap(int i,int j,int [] arr){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
