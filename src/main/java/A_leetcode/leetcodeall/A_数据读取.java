package A_leetcode.leetcodeall;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class A_数据读取 {


    public static void main(String[] args) throws IOException {
        //把文件里的内容load进来，保存在内存里，只需要一此io
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        //一个一个的的读取数字
        StreamTokenizer in = new StreamTokenizer(br);
        //设置空格为分隔符
        in.whitespaceChars(' ', ' ');

        //提交答案也用一个内存区区托管
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            //读取 n
            int n = (int) in.nval;
            //获取字符串    in.sval
            //换到下一个字符
            in.nextToken();
            //读取 m
            int m = (int) in.nval;
        }

        out.print("s");
        out.flush();
        out.close();
    }


}
