package xc;
import java.io.*;
import java.util.Arrays;

public class No2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        int [] arr = new int[n];
        int cnts = n;
        s = bf.readLine().split(" ");
        int [] queue = new int[n];
        for (int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        int index = 0;
        int tail = 0;
        int head = 0;
        Arrays.sort(arr);
        while (index<n){
            while (tail>head&&(arr[index] - queue[head])>k){
                head++;
            }
            queue[tail++] = arr[index++];
            if (tail-head==m){
                cnts--;
                head++;
            }
        }
        out.println(cnts);
        out.close();
    }
}
