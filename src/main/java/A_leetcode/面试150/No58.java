package A_leetcode.面试150;

public class No58 {
    //给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
    //单词 是指仅由字母组成、不包含任何空格字符的最大
    //子字符串
    //。
    public static void main(String[] args) {
       String s= "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }

    public  static int lengthOfLastWord(String s) {
        char [] chars = s.toCharArray();
        boolean flag = false;
        int cur = 0;
        for (int i=chars.length-1;i>=0;i--){
            if (chars[i]==' '){
                if (flag==true){
                    break;
                }
            }else {
                flag = true;
                cur++;
            }
        }
        return cur;
    }
}
