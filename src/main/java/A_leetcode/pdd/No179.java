package A_leetcode.pdd;

import java.util.*;

public class No179 {

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{111311, 1113}));
    }
    public static String largestNumber(int[] nums) {
        List<String> heap = new ArrayList<>();
        for (int i = 0;i< nums.length;i++){
            heap.add(String.valueOf(nums[i]));
        }
        Collections.sort(heap,(a,b) -> {
            int length = Math.min(a.length(),b.length());
            for (int i=0;i< length;i++){
                if (a.charAt(i)!=b.charAt(i)){
                    return b.charAt(i)-a.charAt(i);
                }
            }
            //负数 a在前，正数 b在前
            //我们想要 如果 a+b大 返回 负数
            // 如果 b+a 大 返回正数
            return (b + a).compareTo(a + b);
        });
        StringBuilder stringBuilder  = new StringBuilder();
        for (String s:heap){
            stringBuilder.append(s);
        }
        while (stringBuilder.length()>1&&stringBuilder.charAt(0)=='0'){
            stringBuilder.delete(0,1);
        }
        return stringBuilder.toString();
    }
}
