package A_leetcode.面试150;

public class 爬楼梯 {
    public static void main(String[] args) {
        int[] binaryArray = new int[32];
        printBinary(23);
    }
    public static void printBinary(int number) {
        // 创建一个长度为32的数组，用于存储二进制表示的每一位
        int[] binaryArray = new int[32];

        // 将整数转换为二进制表示，并存储在数组中
        for (int i = 31; i >= 0; i--) {
            binaryArray[i] = number & 1; // 获取当前位的值（0或1）
            number >>= 1; // 将整数右移一位，准备处理下一位
        }

        // 打印二进制表示
        for (int digit : binaryArray) {
            System.out.print(digit);
        }
        System.out.println();
    }

}
