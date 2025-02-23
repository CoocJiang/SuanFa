package kdxf;
import java.io.*;
public class No3 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");

        int size = Integer.parseInt(s[0]);
        int [] arr = new int[size];
        s = bf.readLine().split(" ");
        int num = 0;
        for (int i = 0; i < size; i++) {
            num = Integer.parseInt(s[i]);
            arr[i] = num;
        }
        long [] ans = new long[size];
        for (int i = 0;i<size;i++){
            long sum = arr[i];
            ans[i] = process(arr,i,i,sum);
        }
        for (int i = 0;i<size;i++){
            out.print(ans[i]+" ");
        }
        out.close();
    }

    public static long process(int [] arr,int l,int r,long sum){
        long p1 = sum;
        long p2 = sum;
        //往左or往右
        if (l>0&&arr[l-1]>sum){
            p1 =Math.max(process(arr,l-1,r,sum+arr[l-1]),sum);
        }
        if (r+1<arr.length&&arr[r+1]>sum){
            p2 =Math.max(process(arr,l,r+1,sum+arr[r+1]),sum);
        }
        return Math.max(p1,p2);
    }
}
