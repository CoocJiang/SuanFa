package b_b动态规划.暴力递归;

public class 最长子序列 {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longest2(text1, text2));
    }
    //查找两个字符串的最长子序列
    public static int longest(String s1,String s2){
        char [] str1 = s1.toCharArray();
        char [] str2 = s2.toCharArray();
        int ans  = 0;
        ans = process1(str1,str2,str1.length-1,str2.length-1);
        return ans;
    }

    private static int process1(char[] s1, char[] s2, int i, int j) {
        if (i==0&&j==0){
            //当i和j都等于0时，只需要判断这一个
            return s1[i]==s2[j] ? 1:0;
        }else if(i==0){
            //如果i为0，只要在s2中找到一个匹配的即可返回
            if (s1[i]==s2[j]){
                return 1;
            }else {
                return process1(s1,s2,i,j-1);
            }
        }else if(j==0){
            //如果i为0，只要在s2中找到一个匹配的即可返回
            if (s1[i]==s2[j]){
                return 1;
            }else {
                return process1(s1,s2,i-1,j);
            }
        }else {
            //如果i和j都不为0，这时候分情况讨论
            //1 默认以i为结尾，j-1
            int m = process1(s1,s2,i,j-1);
            //2 默认以j为结尾，i-1
            int n = process1(s1,s2,i-1,j);
            //当他们两个相等时可以以i，j为结尾
            int s = s1[i]==s2[j]? 1+process1(s1,s2,i-1,j-1) :0;
            //从以上结果选择最大的返回即可
            return Math.max(Math.max(n,m),Math.max(m,s));
        }
    }
    //动态规划优化
    public static int longest2(String text1, String text2){
        char [] str1 = text1.toCharArray();
        char [] str2 = text2.toCharArray();
        //dp表每个位置就带表，dp[i][j]代表s1到i，s2到j，他们之间最大到最长子序列长度
        int [][] dp = new int[text1.length()][text2.length()] ;
        //初始化dp表，根据上面的递归函数，我们分析得出，dp[i][j]的值由dp[i-1][j]，dp[i][j-1]，dp[i-1][j-1]+1中最大的决定
        if (str1[0]==str2[0]){
            dp[0][0]=1;
        }
        for (int i = 1; i< text1.length(); i++){
            dp[i][0] = str1[i]==str2[0]? 0:dp[i-1][0];
        }
        for (int i = 1; i< text2.length(); i++){
            dp[0][i] = str1[0]==str2[i]? 0:dp[0][i-1];
        }
        for (int i = 1; i< text1.length(); i++){
            for (int j = 1; j< text2.length(); j++){
                int p1 = dp[i - 1][j];
                int p2 = dp[i][j - 1];
                int p3 = str1[i] == str2[j] ? (1 + dp[i - 1][j - 1]) : 0;
                dp[i][j] = Math.max(p1, Math.max(p2, p3));
            }
        }
        return dp[text1.length()-1][text2.length()-1];
    }

}
