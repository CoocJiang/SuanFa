package A_leetcode.leetcodeall;

public class No739 {

    public static int [] answer;

    public static  int [] stack = new int[10000];
    public static int[] dailyTemperatures(int[] temperatures) {
        answer = new int [temperatures.length];
        //指向数组栈的索引
        int r = 0;
        //i指向temperatures的索引
        //遍历整个温度数组
        for (int i=0;i<temperatures.length;i++){
            while (r>0&&temperatures[i]>temperatures[stack[r-1]]){
                r--;
                //因为是i让r弹出，所以i出的温度是离r最近且大于i的
                answer[stack[r]] = i-stack[r];
            }
            //栈中存储的是索引
            stack[r] = i;
            r++;
        }
        return answer;
    }
}
