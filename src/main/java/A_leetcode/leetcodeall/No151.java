package A_leetcode.leetcodeall;

public class No151 {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
    public static String reverseWords(String s) {
        int length = s.length();
        char [] queue = new char[length];
        int l = 0;
        int r = 0;
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i =0;i<length;){
            while (i<length&&chars[i]!=' '){
                queue[r++] = chars[i++];
            }
            StringBuilder str = new StringBuilder();
            while (l<r){
                str.append(queue[l++]);
            }
            stringBuilder.insert(0,str.toString()+" ");
            while (i<length&&chars[i]==' '){
                i++;
            }
        }
        return stringBuilder.toString().trim();
    }
}
