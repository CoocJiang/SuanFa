package A_leetcode.笔试;

import java.io.*;
import java.util.Arrays;

public class test11 {

    public static void main(String[] args) throws IOException {

//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt("9");
//        s = bf.readLine().split(" ");
        int [] arr = {1,2,3,4,3,7,9,1,2};

        int first = Math.max(arr[1],arr[arr.length-2]);
        int second = Math.min(arr[1],arr[arr.length-2]);
        int sum = arr[0]+arr[arr.length-1];
        if (arr.length > 4) {
            for (int i = 1; i < arr.length - 1; i++) {
                sum+=arr[i];
                if ((arr[i - 1] + arr[i + 1]) > first) {
                    second = first;
                    first = arr[i - 1] + arr[i + 1];
                    continue;
                } else if((arr[i - 1] + arr[i + 1]) >second){
                        second = arr[i - 1] + arr[i + 1];
                }
            }
           sum-=first;
            sum-=second;
        } else {
            Arrays.sort(arr);
        }
        System.out.println(sum);

    }


    public static String process(int [] arr){
      int [] ans = new int[arr.length];
      ans[0] = arr[1];
      int first = 0;
      int second = 0;
      ans[arr.length-1] = arr[arr.length-2];
        int []result;
        if (arr.length>4){
            result = new int [arr.length-4];
            for (int i=1;i<arr.length-1;i++){
                ans[i] = arr[i-1]+arr[i+1];
                if (ans[i]>first){
                    second = first;
                    first=i;
                    continue;
                }else {
                    if (ans[i]>second){
                        second=i;
                    }
                }
            }
            if (first==0){
                arr[1] = 0;
            }else if (first== arr.length-1){
                arr[arr.length-2] = 0;
            }else {
                arr[first-1] = 0;
                arr[first+1] = 0;
            }
            if (second==0){
                arr[1] = 0;
            }else if (second== arr.length-1){
                arr[arr.length-2] = 0;
            }else {
                arr[second-1] = 0;
                arr[second+1] = 0;
            }
            for (int i=0;i<arr.length-4;i++){
                int index = i;
                while (arr[index]==0){
                    index++;
                }
                result[i] = arr[index];
            }
        }else {
            Arrays.sort(arr);
            result = new int[1];
            result[0] = arr[1];
        }
        return null;
    }
}
