package NowCoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.*;

public class 线段重合 {
    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    public static class Main {
        public static void main(String[] args)throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int size = Integer.parseInt(bf.readLine());
            int  [][] arr = new int[size][2];
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (int i = 0; i < size; i++) {
                String [] input = bf.readLine().split(" ");
                arr[i][0] = Integer.parseInt(input[0]);
                arr[i][1] = Integer.parseInt(input[1]);
            }
            Arrays.sort(arr, new Comparator<int []>() {
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            //首先加入第一个元素
            minHeap.add(arr[0][1]);
            int cur;
            int max = 0;
            for(int i=1;i<size;i++){
                cur = minHeap.peek();
                if(cur<=arr[i][0]){
                    minHeap.remove(cur);
                }
                minHeap.add(arr[i][1]);
                max = Math.max(minHeap.size(),max);
            }
            PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
            out.println(max);
            out.flush();
            out.close();
        }
    }
}
