package tencentTest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class qunaer {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[] as = reader.readLine().split(" ");
        // 自定义比较器
        Comparator<String> customComparator = (s1, s2) -> {
            // 仅进行字符串比较，无需实际拼接
            return (s1 + s2).compareTo(s2 + s1);
        };

        // 打印结果
        for (String str : as) {
            System.out.printf(str);
        }
    }
}
