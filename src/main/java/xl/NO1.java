package xl;

import java.io.*;

public class NO1 {
    static int [] arr = new int[100001];
    static int length = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out  = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        length = s.length;
        if (length>1){
            for (int i = 0;i<length;i++){
                arr[i] = Integer.parseInt(s[i]);
            }
            int ans = process(1,arr,3,1);
            out.println(ans);
        }else {
            out.println(1);
        }
        out.close();
    }

    private static int process(int index, int[] arr,int k,int max) {
        if (index == length){
                return  max;
        }else {
            int p1 = 0;
            int p2 = 0;
            if (arr[index]==arr[index-1]){
                p1 = process(index+1,arr,k,max+1);
            }
            p2 = process(index+1,arr,k,1);
            if (k>0){
                int num = arr[index];
                arr[index] = arr[index-1];
                p2 = Math.max(process(index+1,arr,k-1,max+1),p2);
                arr[index] = num;
            }
            return Math.max(p1,p2);
        }
    }


}
