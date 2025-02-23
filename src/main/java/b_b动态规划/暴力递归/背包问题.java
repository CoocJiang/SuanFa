package b_b动态规划.暴力递归;

public class 背包问题 {
    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7, 3, 1, 7,};
        int []values =  {5, 6, 3, 19, 12, 4, 2};
        int bag = 15;
        System.out.println(maxValue2(weights,values,bag));
    }

    public static int maxValue(int [] weight,int []value,int bag){
        int ans = procece(weight,value,0,bag);
        return ans;
    }

    private static int procece(int[] weight, int[] value, int index, int bag) {
        if (bag<0){
            return -1;
        }
        if (index==weight.length){
            return 0;
        }
        //从index 0 开始，每一个位置只有两种选择，选当前物品或者不选，然后在从这两种情况里面选择最大值返回就可以
        //1.不选，直接往后调用下一个process
        int n  =  procece(weight,value,index+1,bag);
        //2.选择当前位置
            //首先需要判断选择当前位置容量是否充裕
        int m = procece(weight,value,index+1,bag-weight[index]);
        if (m<0){
            //不能选
            return n;
        }else {
             return   Math.max(n,m+value[index]);
        }
    }

    //动态规划优化
    public static int maxValue2(int [] weight,int []value,int bag){
        int [][] db = new int [weight.length][bag+1];
        for (int i=weight.length-2;i>=0;i--){
            for (int j=bag;j>=0;j--){
                //不选的情况
                int n = db[i+1][j];
                //选的情况
                int m = -1;
                if (j-weight[i]>=0){
                    m = value[i]+db[i+1][j-weight[i]];
                }
                db[i][j] =Math.max(n,m);
            }
        }
        return db[0][bag];
    }
}
