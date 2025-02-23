package 二分查找.二分答案法;

public class No875 {

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int r = 0;
        int l = 1;
        for(int i:piles){
            r = Math.max(r,i);
        }
        int ans = r;
        while(l<=r){
            int m = l+((r-l)>>1);
            if(process(piles,m,h)){
                ans = m;
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return ans;
    }

    public static boolean process(int []piles,int speed,int h){
        int ans = 0;
        for(int i = 0;i<piles.length;i++){
            ans += (piles[i]+speed-1)/speed;
            if (ans>h){
                return false;
            }
        }
        if(ans<=h){
            return true;
        }else{
            return false;
        }
    }
}
