package tencentTest1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param a int整型ArrayList
     * @return int整型ArrayList
     */
    public static ArrayList<Integer> newArray (ArrayList<Integer> a) {
        // write code here
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i:a) {
            int result =  process(i);
            if (result>=0){
                ans.add(result);
            }
        }
        return ans;
    }


    public static int process(int num){
        String s = String.valueOf(num);
        int r = s.length()-1;
        StringBuilder stringBuilder = new StringBuilder();
        while (r>=0){
            char c = s.charAt(r--);
            if (c!='2'){
                stringBuilder.insert(0,c);
            }
        }

        while (stringBuilder.length()>1&&stringBuilder.charAt(0)=='0'){
            stringBuilder.delete(0,1);
        }
        if (stringBuilder.length()<1){
            return -1;
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(12);
        list.add(20);
        list.add(2);
        list.add(7);
        newArray(list).forEach(System.out::println);
    }
}
