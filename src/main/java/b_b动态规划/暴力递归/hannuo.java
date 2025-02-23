package b_b动态规划.暴力递归;

public class hannuo {
    public static void main(String[] args) {
        LeftToRight(3);
        highHanNuo("左","右","中",3);
    }


    public static void highHanNuo(String from,String to,String other, int n){
        if (n==1){
            System.out.println("move"+n+"from"+from+"to"+to);
            return;
        }
        //将n-1移动到other腾出位置
        highHanNuo(from,other,to,n-1);
        //在把n移动到 to
        System.out.println("move"+n+"from"+from+"to"+to);
        //把移动到 other 的n-1 在移动回to
        highHanNuo(other,to,from,n-1);
    }






    //第一步 n-1从左 到中
    // 1从左到右
    // n-1从中到右

    //下面是汉诺塔低级版

    //将圆盘从左移到右,中间可用
    public static void LeftToRight(int n){
        if (n==1){
            //如果只有一个直接移到右边·
            System.out.println("将"+n+"从左移到右");
            return;
        }else {
            //先把前n-1移动到中间
            LeftToMid(n-1);
            //腾位置之后把n移到右边
            System.out.println("将"+n+"从左移到右边");
            //再把移到中间到从中间移到右边
            MidToRight(n-1);
        }
    }
    //从中移到到右
    public static void MidToRight(int n){
        if (n==1){
            System.out.println("将"+n+"中移到右");
            return;
        }else {
            //将n-1从中移动到左
            MidtoLeft(n-1);
            //腾完n-1之后，将n从中移动到右边
            System.out.println("将"+n+"从中移到右");
            //再把移到左边的n-1从左移动到右边
            LeftToRight(n-1);
        }
    }
    //从中移到左
    public static void MidtoLeft(int n){
        if (n==1){
            System.out.println("将"+n+"从中移到左");
            return;
        }else {
            //先把n-1移动到右边
            MidToRight(n-1);
            //腾完位置
            System.out.println("将"+n+"从中移到左");
            //在把移动到右边的移动到左边
           RightToLeft(n-1);
        }
    }
    //从右移动到左边
    public static void RightToLeft(int n){
        if (n==1){
            System.out.println("将"+n+"从右移到左");
            return;
        }else {
            //先把n-1移动到中
            RighttoMid(n-1);
            //腾完位置
            System.out.println("将"+n+"从右移到左");
            //在把移动到中的移动到左边
            MidtoLeft(n-1);
        }
    }

    //从左移到中
    public static void LeftToMid(int n){
        if (n==1){
            System.out.println("将"+n+"从左移到中");
            return;
        }else {
            //将n-1移动到右边
            LeftToRight(n-1);
            //在把n移动的到中
            System.out.println("将"+n+"从左移动到中间");
            //再把n-1移动到中间
            RighttoMid(n-1);
        }
    }
    //从右到中
    public static void RighttoMid(int n) {
        if (n == 1) {
            System.out.println("将" + n + "从右移到中");
            return;
        } else {
            //将n-1移动到左边
            RightToLeft(n - 1);
            //在把n移哦的到中
            System.out.println("将" + n + "从右移动到中间");
            //再把n-1移动到中间
            LeftToMid(n - 1);
        }
    }
}
