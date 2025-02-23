package mdn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class No1 {
    // 递归方法将整数转换为字符串
    public static void intToString(int n, StringBuilder sb) {
        // 处理负数
        if (n < 0) {
            sb.append('-');  // 添加负号
            n = -n;          // 转换为正数
        }

        // 基本情况：递归结束的条件
        if (n >= 10) {
            intToString(n / 10, sb); // 递归调用
        }

        // 将当前的最后一位数字转换为字符并添加到 StringBuilder 中
        sb.append((char) ('0' + (n % 10)));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入整数
        System.out.print("请输入一个整数: ");
        int n = scanner.nextInt();

        StringBuilder sb = new StringBuilder();
        intToString(n, sb);  // 调用转换函数

        // 输出结果
        System.out.println("整数 " + n + " 的字符串表示为: " + sb.toString());

        scanner.close(); // 关闭扫描器
    }
}
