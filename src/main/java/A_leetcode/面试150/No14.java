package A_leetcode.面试150;

public class No14 {
    public static void main(String[] args) {
        String [] s = {"ab", "a"};
        System.out.println(longestCommonPrefix(s));
    }
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder premax = new StringBuilder();
        for (int i=0;i<200;i++){
            char s ;
            if(strs[0].length()>i){
              s = strs[0].charAt(i);
            }else {
                return premax.toString();
            }
            for (int j = 1;j<strs.length;j++){
                if(strs[j].length()<=i){
                    return premax.toString();
                }
                if (strs[j].charAt(i)!=s){
                    return premax.toString();
                }
            }
            premax.append(s);
        }
        return premax.toString();
    }

//    public static String longestCommonPrefix1(String[] strs){
//        for (int)
//
//
//    }
}
