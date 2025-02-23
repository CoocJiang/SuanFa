package wylh;

import java.io.*;


public class No2 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        String[] s = bf.readLine().split(" ");

        int x = Integer.parseInt(s[0])+1;
        int y = Integer.parseInt(s[1])+1;

        double k = 1.00*y/x;

        long count = 1;
        long shang = 1;

        double newy = 0;
        long next = 0;
        for (int newx = 1;newx<=x;newx++){
            newy = newx*k;
            if (newy % 1 == 0) {
                //在交叉点
                count  += (int) (newy - shang);
                shang = (int) newy;
            }else {
                next = (int) (newy+1);
                count+=next-shang+1;
                shang = (int) (next);
            }
        }
        out.println(count);
        out.close();
    }
}
