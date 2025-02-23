package A_leetcode.面试150;


public class H指数 {
    public static void main(String[] args) {
        int [] arr = new int[]{0};
        System.out.println(hIndex(arr));
    }
    public static int hIndex(int[] citations) {
        int right = citations.length;
        int left = 0;
        int mid = 0;
        while (left<right){
            mid = (right+left)/2;
            if (check(citations,mid)){
                left = mid;
            }else {
                right =mid-1;
            }
        }
        return  right;
    }
    public static boolean check(int []citations,int mid){
        int ans= 0;
        for(int i = 0;i<citations.length;i++){
            if(citations[i]>=mid){
                ans++;
            }
        }
        return ans>=mid;
    }
}
