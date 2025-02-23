package rx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No1 {

    public static void main(String[] args) {
        System.out.println(maxFlavor(new int[]{6, 5, 8, 9, 10}, 4));
    }

    public static int maxFlavor (int[] price, int k) {
        // write code here
        Arrays.sort(price);
        k =k - 2;
        int n = price.length-1;
        int ans  = price[n]-price[0];
        int end = n-1;
        int start = 1;
        List<Integer> list = new ArrayList<>();
        list.add(price[0]);
        list.add(price[n]);
        while(k>0){
            int num = 0;
            int index = n;
            boolean flag = true;
            for (int i = start;i<=end;i++){
                flag = true;
                for (int j:list){
                    if (Math.abs(j-price[i])<num){
                       flag = false;
                    }
                }
                num = Integer.MAX_VALUE;
                if (flag){
                    for (int j:list){
                        num = Math.min(j - price[i], num);
                    }
                }
            }
            ans = Math.min(ans,num);
            list.add(price[index]);
            k--;
        }
        return ans;
    }



}
