package A_leetcode.leetcodeall;

public class No461 {



    //两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
    //
    //给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
    public int hammingDistance(int x, int y) {
        int temp = x^y;
        int couont = 0;
        for (int i=0;i<32;i++){
            if ((temp&(1<<i))!=0){
                couont++;
            }
        }
        return couont;
    }
}
