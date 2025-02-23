package A_leetcode.面试150;

public class 找出字符串中第一个匹配的下标 {
    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
    }
    public static int strStr(String haystack, String needle) {
        char []hay = haystack.toCharArray();
        char []nee = needle.toCharArray();
        if(nee.length>hay.length){
            return-1;
        }
        for(int i=0;i<=hay.length-nee.length;i++){
            int j=0;
            for(;j<nee.length;j++){
                if(nee[j]==hay[j+i]){
                }else {
                    break;
                }
            }
            if(j==nee.length){
                return i;
            }
        }
        return -1;
    }
}
