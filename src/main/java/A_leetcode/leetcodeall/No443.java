package A_leetcode.leetcodeall;

public class No443 {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a'}));
    }

    public static int compress(char[] chars) {
        StringBuilder stringBuilder = new StringBuilder();
        int left = 0;
        int right = 1;
        for (;left<chars.length;){
            while (right<chars.length&&chars[left]==chars[right]){
                right++;
            }
            if (right-left>1){
                stringBuilder.append(chars[left]).append(right-left);
            }else {
                stringBuilder.append(chars[left]);
            }
            left = right;
            right = left+1;
        }
        char[] chars1 = stringBuilder.toString().toCharArray();
        for (int i=0;i<chars1.length;i++){
           chars[i] = chars1[i];
       }
        return stringBuilder.length();
    }
}
