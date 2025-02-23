package b_贪心算法实战;

import java.util.*;


public class 字符串大小排序 {
        public static void main(String[] args) {
            HashMap<Integer,Integer> map = new HashMap<>();
            List<Integer> valuelist = new ArrayList<>(map.values());
            String[] strArray = {"de", "abc", "f"};
            String sortedString = lowerStirng(strArray);
            System.out.println("Sorted concatenated string: " + sortedString);
        }
    public static class mycomperator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }
    }
    public static String lowerStirng(String[] str){
        if (str==null || str.length==1){
            return "";
        }
        Arrays.sort(str,new mycomperator());
        String res ="";
        for (int i = 0;i< str.length;i++){
            res = res+str[i];
        }
            return res;
    }
}
