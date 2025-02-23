package baidu;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class No3 {

    static int [] cards;
    static HashSet<String> set ;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String  [] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int ans = 0;
        cards = new int[n+1];
        set = new HashSet<>();
        Arrays.fill(cards,4);
        if (n>3){
            process(14,new StringBuilder());
        }
        out.println(set.size());
        out.close();
    }

    public static void process(int need,StringBuilder stringBuilder){
        if (need==0){
            char[] chars = stringBuilder.toString().toCharArray();
            Arrays.sort(chars);
            set.add(new String(chars));
        }else if (need==3){
            for (int i = 1;i<cards.length;i++){
                //要单个
                if (cards[i]>2){
                    cards[i]-=3;
                    stringBuilder.append(i).append(i).append(i);
                    process(0,stringBuilder);
                    cards[i]+=3;
                    stringBuilder.delete(stringBuilder.length()-3,stringBuilder.length());
                }
            }
            //用顺子
            for (int i = 1;i<cards.length-2;i++){
                //要单个
                if (cards[i]>0&&cards[i+1]>0&&cards[i+2]>0){
                    cards[i]--;
                    cards[i+1]--;
                    cards[i+2]--;
                    stringBuilder.append(i).append(i+1).append(i+2);
                    process(0,stringBuilder);
                    cards[i]++;
                    cards[i+1]++;
                    cards[i+2]++;
                    stringBuilder.delete(stringBuilder.length()-3,stringBuilder.length());
                }
            }
        }else if (need==2){
            for (int i = 1;i<cards.length;i++){
                //要单个
                if (cards[i]>1){
                   stringBuilder.append(i).append(i);
                   process(0,stringBuilder);
                   stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());
                }
            }
        }else {
            for (int i = 1;i<cards.length;i++){
                //要单个
                if (cards[i]>2){
                    cards[i]-=3;
                    stringBuilder.append(i).append(i).append(i);
                    process(need-3,stringBuilder);
                    cards[i]+=3;
                    stringBuilder.delete(stringBuilder.length()-3,stringBuilder.length());
                }
            }
            //用顺子
            for (int i = 1;i<cards.length-2;i++){
                //要单个
                if (cards[i]>0&&cards[i+1]>0&&cards[i+2]>0){
                    cards[i]--;
                    cards[i+1]--;
                    cards[i+2]--;
                    stringBuilder.append(i).append(i+1).append(i+2);
                    process(need-3,stringBuilder);
                    cards[i]++;
                    cards[i+1]++;
                    cards[i+2]++;
                    stringBuilder.delete(stringBuilder.length()-3,stringBuilder.length());
                }
            }
        }
    }
}
