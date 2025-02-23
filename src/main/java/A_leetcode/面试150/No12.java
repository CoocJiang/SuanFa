package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.List;

public class No12 {


    public static void main(String[] args) {
        System.out.println(intToRoman(500));
    }
    //整数转罗马数字

    public  static String intToRoman(int num) {
        List<Character> characters = new ArrayList<>();
        while (num>=1000){
            num-=1000;
            characters.add('M');
        }
        if (num>=900){
            characters.add('C');
            characters.add('M');
            num-=900;
        }
        if (num>=400){
            if (num>=500){
                characters.add('D');
                num-=500;
            }else {
                characters.add('C');
                characters.add('D');
                num-=400;
            }
        }
        while (num>=90){
            if (num>=100){
                characters.add('C');
                num-=100;
            }else {
                characters.add('X');
                characters.add('C');
                num-=90;
            }
        }
        if (num>=40) {
            if (num >= 50) {
                characters.add('L');
                num -= 50;
            } else {
                characters.add('X');
                characters.add('L');
                num -= 40;
            }
        }
           while (num>=9){
               if (num>=10){
                   characters.add('X');
                   num-=10;
               }else {
                   characters.add('I');
                   characters.add('X');
                   num-=9;
               }
           }

           if (num>=4){
               if (num>=5){
                   characters.add('V');
                   num-=5;
               }else {
                   characters.add('I');
                   characters.add('V');
                   num-=4;
               }
           }
           while (num>0){
               characters.add('I');
               num--;
           }
            StringBuilder sb = new StringBuilder();
           for (Character c:characters){
                sb.append(c);
           }
            return sb.toString();
    }
}
