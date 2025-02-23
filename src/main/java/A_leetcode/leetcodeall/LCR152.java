package A_leetcode.leetcodeall;

public class LCR152 {
    public static void main(String[] args) {
        System.out.println(verifyTreeOrder(new int[]{1, 2, 3, 4, 5}));
    }
    public static boolean verifyTreeOrder(int[] postorder) {
        if (postorder.length<2){
            return true;
        }
        return process(postorder,0,postorder.length-1);
    }

    public static boolean process(int[] postorder,int l,int r) {
        if (l>=r){
            return true;
        }
        //找到第一个大于postorder[r]的数
        int mid = l;
        int pre = 0;
        for (;mid<r;mid++){
           if (postorder[mid]>postorder[r]){
               break;
           }
        }
        for (int i = mid+1;i<r;i++){
            if (postorder[i]<postorder[r]) {
                return false;
            }
        }
        boolean leftflag = process(postorder,l,mid-1);
        boolean rightflag = process(postorder,mid,r-1);
        return leftflag&&rightflag;
    }
}
