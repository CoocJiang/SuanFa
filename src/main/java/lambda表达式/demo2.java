package lambda表达式;

import java.util.Arrays;
import java.util.TreeSet;

public class demo2 {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>((o1,o2)-> o1.compareTo(o2));
        int[] ints = {1, 2, 3,};
        Arrays.sort(ints);


    }
}
