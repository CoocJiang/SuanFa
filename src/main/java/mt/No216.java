package mt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class No216 {

    public static void main(String[] args) {
        combinationSum3(9,45).forEach(System.out::println);
    }
    static  List<List<Integer>> ans;
    public static List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        for (int i = 1;i<=10-k;i++){
            List<Integer> list = new ArrayList<>();
            list.add(i);
            process (list,n,i,k);
        }
        return ans;
    }

    private static void process(List<Integer> list, int n,int sum,int k) {
        if (sum==n&&list.size()==k){
            ans.add(new ArrayList<>(list));
        }else if (sum<n){
            if (list.size()<k){
                for (int i = list.get(list.size()-1)+1;i<10;i++){
                    list.add(i);
                    process (list,n,i+sum,k);
                    list.remove(list.size()-1);
                }
            }else {
                return;
            }
        }else  {
            return;
        }
    }
}
