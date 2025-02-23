package A_leetcode.Leetcode.msb算法;

import java.sql.Array;

public class 河南国旗问题 {
    public static void main(String[] args) {
        int [] arr =new int[]{1,2,3,4,7,8,2,1,1,1,3,1,4};
        quicksort(arr,0,arr.length-1 );
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println(" ");
    }
    public static void quicksort(int arr[],int L ,int R){
        if (L>=R){
            return;
        }
         int[] equalarea=partition(arr,L, R);
        quicksort(arr,L,equalarea[0]);
        quicksort(arr,equalarea[1],R);
    }
    public static int[]partition (int arr[],int L,int R){
        if (R < L){
            return null;
        }
        if (L == R){
            return new int[] {1,1};
        }
        int num = arr[R];
        int left = L;
        int right = R-1;
        int xiao = L-1;
        int da = R;
        while(left!=da){
            if (arr[left]>num){
                swap(right,left,arr);
                right--;
                da--;
            } else if (arr[left]==num) {
                left++;
            } else {
                swap(left,xiao+1,arr);
                left++;
                xiao++;
            }
        }
        swap(da,R,arr);
        return new int[]{xiao,da};
    }
    public  static void swap(int i,int j,int [] arr){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
