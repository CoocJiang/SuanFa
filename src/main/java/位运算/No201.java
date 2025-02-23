package 位运算;

public class No201 {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
    }

    //给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
    public static int rangeBitwiseAnd(int left, int right) {
        while (right>left){
            right = right-(right&(~right+1));
        }
        return right;
    }

}
