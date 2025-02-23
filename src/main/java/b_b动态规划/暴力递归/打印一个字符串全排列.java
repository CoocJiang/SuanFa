package b_b动态规划.暴力递归;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class 打印一个字符串全排列 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        for(String i:getans(strings)){
            System.out.println(i);
        }
    }
    public static List<String> getans(List<String> strings){
        List<String> ans = new ArrayList<>();
        String path = "";
        allsort(strings,path,ans);
        return ans;
    }
    public static void allsort(List<String> str,String path,List<String> ans){
       if (str.isEmpty()){
           ans.add(path);
           return;
       }
//       String path2;
//       List<String> strs = new ArrayList<>();
//       for (String i:str){
//           strs=str;
//           path2 = path+i;
//           strs.remove(i);
//           allsort(strs,path2,ans);
//       }


//        原来的写法并没有创建新的List，而是将strs指向了原来的List
        String path2;
        List<String> strs = new ArrayList<>();
        for (String i:str){
            strs=new ArrayList<>(str);
            path2 = path+i;
            strs.remove(i);
            allsort(strs,path2,ans);
        }
    }
}
