package jd;


import java.io.*;
import java.util.PriorityQueue;

public class No2 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int [] shunxu = new int[26];
        String s = bf.readLine();
        for (int i = 0;i<26;i++){
            shunxu[s.charAt(i)-'a'] = i;
        }
        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        PriorityQueue<String> heap = new PriorityQueue<>(((o1, o2) -> {
            int r = 0;
            int len1 = o1.length();
            int len2 = o2.length();
            while (r<Math.min(len1,len2)){
                if (o1.charAt(r)==o2.charAt(r)){
                    r++;
                    continue;
                }else {
                    return shunxu[o1.charAt(r)-'a'] - shunxu[o2.charAt(r)-'a'];
                }
            }
            return len1-len2;
        }));
        for (int i = 0;i<n;i++){
            s = bf.readLine();
            heap.add(s);
        }
        while (!heap.isEmpty()){
            out.println(heap.poll());
        }
        out.close();
    }
}
