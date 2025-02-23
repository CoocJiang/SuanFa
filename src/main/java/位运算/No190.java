package 位运算;

public class No190 {
    public static void main(String[] args) {
        System.out.println(reverseBits(0b00000010100101000001111010011100));
    }
    // you need treat n as an unsigned value
//    public  static int reverseBits(int n) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i=31;i>=0;i--){
//            if ((n&(1<<i))!=0){
//                stringBuilder.append("1");
//            }else {
//                stringBuilder.append("0");
//            }
//        }
//        String s = stringBuilder.reverse().toString();
//        System.out.println(s);
//        int offset = 1;
//        int ans = 0;
//        for(int i=31;i>=0;i--){
//            ans+=(s.charAt(i)-'0')*offset;
//            offset*=2;
//        }
//        return ans;
//    }

    //颠倒给定的 32 位无符号整数的二进制位。
    //提示：
    //请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，
    // 输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，
    // 其内部的二进制表示形式都是相同的。
    //示例 1：
    //
    //输入：n = 00000010100101000001111010011100
    //输出：964176192 (00111001011110000010100101000000)
    //解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
    //     因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
    public static int reverseBits(int n) {
        int ans = 0;
        for (int i=0;i<32;i++){
            if ((n&(1<<i))!=0){
                ans+=1<<(31-i);
            }
        }
        return ans;
    }
}
