package NowCoder;

import java.util.HashSet;

public class 字符串的全部子序列 {



    public static void main(String[] args) {
        String s = "ab";
        generatePermutation(s);
    }

    private static HashSet<String> set;

    public static String[] generatePermutation (String s) {
        char[] chars = s.toCharArray();
        set=new HashSet<>();
        process1(chars,0,new char[chars.length],0);
        String[] stringArray = set.toArray(new String[0]);
        return stringArray;
    }

    public void process(char[] chars,int index,StringBuilder stringBuilder){
        if (chars.length==index){
           set.add( stringBuilder.toString());
            return;
        }
        //当前这个字符有两种情况，要或者不要
            //如果要
        stringBuilder.append(chars[index]);
        process(chars,index+1,stringBuilder);
        //如果不要,先删除刚才加入的
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        process(chars,index+1,stringBuilder);
    }

    public static void process1(char[] chars,int index,char [] ans,int size){
        if (chars.length==index){
            //使用char数组转换为字符串
            set.add(new String(ans,0,size));
            return;
        }
        //当前这个字符有两种情况，要或者不要
        //如果要
        ans[size] = chars[index];
        process1(chars,index+1,ans,size+1);
        //如果不要,先删除刚才加入的
        process1(chars,index+1,ans,size);
    }
}
