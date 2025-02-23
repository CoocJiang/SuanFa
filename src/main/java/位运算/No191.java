package 位运算;

public class No191 {
    //编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中
    //设置位
    // 的个数（也被称为汉明重量）。
    public int hammingWeight(int n) {
        int count = 0;

        for (int i=31;i>=0;i--){
            if ((n&(1<<i))!=0){
                count++;
            }
        }
        return count;
    }
}
