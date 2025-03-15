package A_leetcode.leetcodeall;

public class No3340 {
    public boolean isBalanced(String num) {
        int ou = 0;
        int ji = 0;
        int len = num.length();
        int index = 0;
        boolean flag = true;
        while(index<len){
            if(flag){
                ou+=num.charAt(index) - '0';
            }else{
                ji+=num.charAt(index) - '0';
            }
            flag = !flag;
            index++;
        }
        return ou==ji;
    }
}
