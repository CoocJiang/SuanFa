package b_b动态规划.暴力递归;

import java.util.HashMap;

public class 贴纸数量问题 {
    //题目五
    //给定一个字符串str，给定一个字符串类型的数组art，出现的字符都是小写英文
    //arf每一个字符串，代表一张贴纸，你可以把单个字符剪开使用，目的是拼出str来返回需要至少多少张贴纸可以完成这个任务。
    //1517 : str= "babac", arr = {"'ba", "C","abcd"}
    //至少需要两张贴纸"ba"和"abcd”，因为使用这两张贴纸，把每一个字符单独剪开，含有2个a、2个b、1个c。是可以拼出str的。所以返回2。
    public static void main(String[] args) {
        String [] str = {"notice","possible"};
        String tar = "basicbasic";
        System.out.println(minStickers2(str,tar));
    }
    public static int minStickers2(String [] stickers,String target){
        HashMap<String,Integer> dp = new HashMap<>();
        int [][] sticker = new int[stickers.length][26];
        for (int i=0;i<stickers.length;i++){
            char[] js = stickers[i].toCharArray();
                for (char j:js){
                    sticker[i][j-'a']++;
                }
        }
        dp.put("", 0);
        int ans = process2(sticker,target,dp);
        return ans==Integer.MAX_VALUE? -1:ans;
    }
    private static int process2(int[][] sticker, String t, HashMap<String,Integer> dp) {
        if (dp.containsKey(t)){
            return dp.get(t);
        }
        char[] target = t.toCharArray();
        int[] tcounts = new int[26];
        for (char i : target) {
            tcounts[i - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sticker.length; i++) {
            int[] s = sticker[i];
            if (s[target[0] - 'a'] > 0) {
                StringBuilder builder = new StringBuilder();
                builder = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    if (tcounts[j] > 0) {
                        int nums = tcounts[j] - s[j];
                        for (int k = 0; k < nums; k++) {
                            builder.append((char) (j + 'a'));
                        }
                    }
                }
                String rest = builder.toString();
                min = Math.min(min, process2(sticker, rest, dp));
            }
        }
        if (min ==Integer.MAX_VALUE){
            dp.put(t,min);
            return min;
        }else {
            dp.put(t,min+1);
            return min+1;
        }
    }

//public static int process2(int[][] stickers, String t) {
//    if (t.length() == 0) {
//        return 0;
//    }
//    char[] target = t.toCharArray();
//    int[] tcounts = new int[26];
//    for (char cha : target) {
//        tcounts[cha - 'a']++;
//    }
//    int N = stickers.length;
//    int min = Integer.MAX_VALUE;
//    for (int i = 0; i < N; i++) {
//        int[] sticker = stickers[i];
//        if (sticker[target[0] - 'a'] > 0) {
//            StringBuilder builder = new StringBuilder();
//            for (int j = 0; j < 26; j++) {
//                if (tcounts[j] > 0) {
//                    int nums = tcounts[j] - sticker[j];
//                    for (int k = 0; k < nums; k++) {
//                        builder.append((char) (j + 'a'));
//                    }
//                }
//            }
//            String rest = builder.toString();
//            min = Math.min(min, process2(stickers, rest));
//        }
//    }
//    return min + (min == Integer.MAX_VALUE ? 0 : 1);
//}



    public static int minStickers1(String [] stickers,String target){
        int ans = process1(stickers,target);
        return  ans;
    }
    public static int process1(String [] stickers,String target){
        //如果现在剩余的target的长度为0，说明我拼接完成
        if (target.length()==0){
            return 0;
        }else {
            int min = Integer.MAX_VALUE;
            for (int i = 0;i<stickers.length;i++){
                String rest = minis(target,stickers[i]);
                if (rest.length()<target.length()){
                    min=Math.min(min,process1(stickers,rest));
                }
            }
            if (min==Integer.MAX_VALUE){
                return min;
            }else {
                return 1+min;
            }
        }
    }
    public  static String minis(String s1,String s2){
        char [] str1 = s1.toCharArray();
        char [] str2 = s2.toCharArray();
        int [] zimu = new int[26];
        for (char i:str2){
            zimu[i-'a']++;
        }
        for (char i:str1){
            zimu[i-'a']--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<zimu.length;i++){
            while (zimu[i]>0){
                stringBuilder.append((char)(i+'a'));
                zimu[i]--;
            }
        }
        return stringBuilder.toString();
    }

}
