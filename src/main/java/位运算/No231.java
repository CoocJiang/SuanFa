package 位运算;

public class No231 {

//    给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
//
//    如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。

//    public boolean isPowerOfTwo(int n) {
//        if(n<=0){
//            return false;
//        }
//        int count = 0;
//        for (int i=31;i>=0;i--){
//            if ((n&1<<i)!=0){
//                count++;
//            }
//        }
//        if (count>1){
//            return false;
//        }
//        return true;
//    }

//    给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
//
//    如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        int s = n&(~n+1);
        return  n==s;
    }
}
