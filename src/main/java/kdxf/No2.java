package kdxf;
import java.io.*;
public class No2 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");

        int size = Integer.parseInt(s[0]);

        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int [] stack = new int[size];

        int l = 0;
        int r = 0;
        s = bf.readLine().split(" ");
        int num = 0;
        for (int i = 0;i<size;i++){
            num = Integer.parseInt(s[i]);
            while (r>l&&stack[r-1]==num){
                num = num+1;
                r--;
            }
            stack[r++] = num;
        }

        while (r>l){
            out.print(stack[l++]+" ");
        }
        out.close();
    }
}
