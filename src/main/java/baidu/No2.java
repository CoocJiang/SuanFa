package baidu;
import java.io.*;
public class No2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine();
        StringBuilder stringBuilder = new StringBuilder(str);
        int n = str.length();
        for (int i = 0;i<n;i++){
            char c = stringBuilder.charAt(i);
            stringBuilder.delete(i,i+1);
            stringBuilder.append(c);
        }
        out.println(stringBuilder.toString());
        out.close();
    }
}
