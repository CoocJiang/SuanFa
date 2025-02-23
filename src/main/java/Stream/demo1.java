package Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class demo1 {

    public String a(){
        return "hello";
    }
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7,8,9);
        List<Integer> collect = list.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("---------------------------");
        List<String> strs = new ArrayList<>();
        Collections.addAll(strs,"zhangsan,23","lisi,24","wangwu,25");
        Map<String, String> collect1 = strs.stream().filter(s->s.split(",")[1].equals("24")).collect(Collectors.toMap(s -> s.split(",")[0], s -> s.split(",")[1]));
        System.out.println(collect1);
        System.out.println("---------------------------");
        List<String> strs2 = new ArrayList<>();
        Collections.addAll(strs2,"aaa,24","bbb,23","ccc,22","ddd,33","eee,30","ff,24","ee,24","ggg,24");
        List<String> strs3 = new ArrayList<>();
        Collections.addAll(strs3,"zz,24","xx,23","vv,22","nnn,33","jjj,30","oo,24","tt,24","kkk,24");
    }
}
