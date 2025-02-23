package b_b动态规划.暴力递归;

public class 字符转换问题 {
    //题目四
    //规定1和A对应、2和B对应、3和C对应.26和Z对应那么一个数字字符串比如"111”就可以转化为：
    //"AAA", "КА"和"AK"
    //给定一个只有数字字符组成的字符串str，返回有多少种转化结果
    public static void main(String[] args) {
        String str = "11111";
        System.out.println(maxValue2(str));
    }
    //将传过来的字符串转换为字符数组
    public static int maxValue(String str){
       return process(0,str.toCharArray());
    }

    //代表index之前的字符已经成功处理
    public static int process(int index,char[]str){
        if (str.length==index){
            return 1;
        }else if(str[index] =='0'){
            return 0;
        }else {
            int ways = process(index+1,str);
            if (str[index]<'3'&&index+1<str.length){
                if (str[index]>'2'&&index+1<str.length&&str[index+1]>'6'){
                    return ways;
                }else {
                    ways+=process(index+2,str);
                }
            }
            return ways;
        }
    }
    //动态规划优化
    public static int maxValue2(String str){
        char [] chars = str.toCharArray();
        int[] db = new int[str.length()+1];
        db[str.length()]=1;
        for (int i=str.length()-1;i>=0;i--){
            if (chars[i]!='0'){
                int ways  = db[i+1];
                if (i+1<chars.length&&chars[i]<'3'){
                    if (chars[i]>'2'&&chars[i+1]>'6') {
                        db[i] =ways;
                    }else {
                        ways+=db[i+2];
                    }
                }
                db[i] = ways;
            }
        }
        return db[0];
    }
}
