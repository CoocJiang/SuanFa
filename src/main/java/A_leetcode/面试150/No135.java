package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class No135 {

    public static void main(String[] args) {
        int [] ratings = {0,1,2,3};
        System.out.println(candy(ratings));
    }
    //n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
    //你需要按照以下要求，给这些孩子分发糖果：//每个孩子至少分配到 1 个糖果。
    //相邻两个孩子评分更高的孩子会获得更多的糖果。//请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
    public static class  keyvalue{
        int key;
        int value;
        public keyvalue(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public static class mycompare implements Comparator<keyvalue>{
        @Override
        public int compare(keyvalue o1, keyvalue o2) {
            return o1.value- o2.value;
        }
    }
    public static int get(int [] ratings){
        //keyvalue用来存储数组每个点对应的索引和分数
        List<keyvalue> keyvalues = new ArrayList<>();
        for (int i=0;i< ratings.length;i++){
           keyvalues.add(new keyvalue(i,ratings[i]));
        }
        keyvalues.sort(new mycompare());
        int  [] map = new int[ratings.length];
        //先加入评分最低的孩子的索引,给他一个糖果
        int count = 1;
        //存入索引以及分发糖果数量
        map[keyvalues.get(0).key] = 1;
        //因为keyvalue已经按评分排过顺序了
        for (int i=1;i<keyvalues.size();i++){
            int cur = 1;
            //依次判断此时所看评分对应的索引的邻居是否在index里，若不在，只用分发一个糖果
            //若在，只需要分发相邻者最大的数量+1
            if (keyvalues.get(i).key-1>=0&&map[keyvalues.get(i).key-1]!=0){
                if (keyvalues.get(i).value>ratings[keyvalues.get(i).key-1]){
                    cur = map[keyvalues.get(i).key-1]+1;
                }
            }
            if (keyvalues.get(i).key+1< map.length&&map[keyvalues.get(i).key+1]!=0){
                if (keyvalues.get(i).value>ratings[ keyvalues.get(i).key+1]){
                    cur = Math.max(cur,map[keyvalues.get(i).key+1]+1);
                }
            }
                map[keyvalues.get(i).key]=cur;
                count = count+cur;
        }
        return count;
    }
    public static int candy(int [] ratings){
        if (ratings.length<1){
            return 0;
        }
        if (ratings.length==1){
            return 1;
        }
        int [] dp  = new int[ratings.length] ;
        int ans = 0;
        for (int i= 0;i< ratings.length;i++){
            ans = ans+process(ratings,dp,i);
        }
        return ans;
    }
    public static int process(int [] ratings,int [] dp,int index){
        if (dp[index]!=0){
            return dp[index];
        }
        if (index-1<0){
            //如果是第一个并且比第二个还小，毫无疑问就是1
            if (ratings[index+1]>=ratings[index]){
                dp[index] = 1;
                return 1;
            }else {
                dp[index]=process(ratings,dp,index+1)+1;
                return dp[index];
            }
        }
        //同理
        if (index+1>=ratings.length) {
            if (ratings[index]<=ratings[index-1]){
                dp[index] = 1;
                return 1;
            }else {
                dp[index]=process(ratings,dp,index-1)+1;
                return dp[index];
            }
        }
        //既不是第一个也不是最后一个，就要判断和左右的关系了，比左右都小直接设置为1
        if (ratings[index-1]>ratings[index]&&ratings[index]<ratings[index+1]){
            dp[index] = 1;
            return 1;
        }
        if (ratings[index]>ratings[index-1]&&ratings[index]>ratings[index+1]){
            dp[index]=Math.max(process(ratings,dp,index-1),process(ratings,dp,index+1))+1;
            return dp[index];
        }
//        如果bu满足比左右都小，说明肯定比其中一方大，我们找出两者小的一方，比小的一方多就可以
        if (ratings[index]>ratings[index-1]){
            if (dp[index-1]!=0){
                dp[index] = dp[index-1]+1;
                return dp[index];
            }
            return dp[index]=process(ratings,dp,index-1)+1;
        }else if (ratings[index]>ratings[index+1]){
            if (dp[index+1]!=0){
                dp[index] = dp[index+1]+1;
                return dp[index];
            }
            return dp[index]=process(ratings,dp,index+1)+1;
        }
        return 1;
    }
    //最优解法
    public static void candy2(int [] ratings){
        int [] dp = new int[ratings.length];
        for (int i=0;i<ratings.length;i++){
            process(ratings,dp,i);
        }

    }

    public static int process2(int ratings[],int dp[],int index){
        if (dp[index]!=0){
            return dp[index];
        }
        if (index==ratings.length-1){
            dp[index] = 1;
            return dp[index];
        }
        if (ratings[index]<ratings[index+1]){
            dp[index] = 1;
            return dp[index];
        }
        return dp[index] = 1+process(ratings,dp,index+1);
    }
}
