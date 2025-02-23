package A_leetcode.Leetcode.msb算法;

public class 排序 {
    //选择
    public static void select(int [] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for (int i =0;i<arr.length;i++){
            int minindex = i;
            for (int j=i+1;j< arr.length;j++){
                minindex = arr[j]<arr[minindex] ? j:minindex;
            }
            swap(i,minindex,arr);
        }
}
    //冒泡排序
    public static void buble(int [] arr){
        if(arr==null||arr.length<2){
            return;
        }
        //在0到i之间排序
        for (int i= arr.length-1;i>=0;i--){
            for (int second = 1;second<i;second++){
                if(arr[second]<arr[second-1]){
                    swap(second,second-1,arr);
                }
            }
        }
    }
    //插入
    public  static void insertsort(int [] arr){
        for(int i=1 ;i<arr.length;i++){
            for (int pre=i-1;pre>=0&&arr[pre]>arr[pre+1];pre--){
              swap(pre,pre+1,arr);
            }
        }
    }
    public  static void swap(int i,int j,int [] arr){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    //arr是有序的数组,二分法找数字
    public static boolean erfen(int arr[] ,int num){
        if(arr==null||arr.length==0){
            return false;
        }
        int L = 0;
        int R = arr.length-1;
        while (R>=L){
            int mid = (R + L)/2;
            if (num>arr[mid]){
                L = mid+1;
            }else if (num<arr[mid]){
                R = mid-1;
            }else {
                return true;
            }
        }
        return false;
    }

    //找到一个数子在数组最左端并前>=num
    public static int finaleft(int arr [],int num){
       int ans = -1;
       int L = 0;
       int R = arr.length-1;
       while (R>= L){
           int mid = (L+R)/2;
           if (num>arr[mid]){
               L = mid+1;
           }else if(arr[mid]>num) {
               R = mid-1;
           }else {
              ans = mid;
              R = mid-1;
           }
       }
        return ans;
    }

    public static void processer(int arr[],int L,int R){
        if (L==R){
            return ;
        }
        int mid = (L+R)/2;
        processer(arr,L,mid);
        processer(arr,mid+1,R);
        merge(arr,L,R,mid);
    }
    public static void merge(int[] arr,int L,int R,int M){
        int [] help = new int[R-L+1];
        int i =0;
        int Mid  = M+1;
        int index = L;
        while (L <= M && Mid <= R){
            if (arr[L]<arr[Mid]){
                help[i] = arr[L];
                L++;
                i++;
            }else {
                help[i] = arr[Mid];
                Mid++;
                i++;
            }
        }
        while (L <= M){
            help[i] = arr[L];
            L++;
            i++;
        }
        while (Mid < R+1 ){
            help[i] = arr[Mid];
            Mid++;
            i++;
        }
       for(int j =0;j< help.length;j++){
           arr[index+j] = help[j];
       }
    }






    public static void main(String[] args) {
        int [] arr = {8,9,6,7,3,2,9,3,1};
        processer(arr,0,arr.length-1);
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
        insertsort(arr);
        for (int i : arr){
            System.out.print(i+" ");
        }
    }
}
