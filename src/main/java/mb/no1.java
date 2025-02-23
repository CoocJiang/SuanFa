package mb;

import java.io.*;

public class no1 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int []arr = new int[n];
        for (int i = 1;i<=n;i++){
           arr[i-1] = i;
        }
        for (int i = 1;i<n;i+=2){
            if (i+1<n){
                swap(i,i+1,arr);
            }
        }
        for (int i = 0;i<n;i++){
            out.print(arr[i]+" ");
        }
        out.close();
    }

    private static void swap(int i,int j,int [] arr){
        int temp = arr[i];
        arr[i] =arr[j];
        arr[j] = temp;
    }
}
