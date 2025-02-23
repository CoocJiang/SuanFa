package lambda表达式;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class demo1 {
    //无参数接口
    public interface  testlambda{
        void test();

    }
    //有参数接口
    public interface testlambda2{
        void test2(int a,int b);
    }
    //有返回值接口
    public interface testlambd3{
        int test2(int a,int b);
    }
    public static void main(String[] args) {
        //（）代表参数列表 ->代表函数体
        testlambda t =()-> System.out.println("无参数lambda表达式");
        t.test();

        //（参数放在里面（名字可以随便））代表参数列表 ->后面 代表函数体
        testlambda2 r2 = (c,d)->System.out.println(c+"无参数lambda表达式"+d);
        r2.test2(1,2);

        //有返回值
        testlambd3 t3 = (a,b)-> a-b;
        System.out.println(t3.test2(1, 2));

        testlambd3 t4 = (a,b)-> {
            System.out.println("有多个逻辑需要加括号");
            return a-b;
        };
        System.out.println(t4.test2(1, 2));



        List<Integer> list = new ArrayList<>();
        Collections.sort(list,(o1,o2)->  o1.compareTo(o2));


    }
}
