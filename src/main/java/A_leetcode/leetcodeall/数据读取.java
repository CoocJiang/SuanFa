package A_leetcode.leetcodeall;

import java.io.*;
import java.util.*;

public class 数据读取 {
        public static void main(String[] args) throws IOException {
            // 读取输入
            BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
            // 分割输入
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]); // 获取 n
            int m = Integer.parseInt(input[1]); // 获取 m
            int k = Integer.parseInt(input[2]); // 获取目标位置的索引
            String[] strings = new String[n]; // 保存字符串数组

            for (int i = 0; i < n; i++) {
                strings[i] = br.readLine(); // 逐行读取字符串数据
            }
            // 获取目标位置的字符串数据
            String target = strings[k - 1]; // 因为数组索引从0开始，所以要减去1
            // 输出目标位置的字符串数据
            PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
            out.println(target);
            out.flush();
            out.close();


        }
}
