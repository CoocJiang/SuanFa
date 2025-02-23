package A_leetcode.leetcodeall;

import java.util.HashMap;

public class No889 {


    public static void main(String[] args) {
        constructFromPrePost(new int[]{1,2,4,5,3,6,7},new int[]{4,5,2,6,7,3,1});
    }
    static HashMap<Integer,Integer> map;
    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
         map= new HashMap<>();
        for (int i = 0;i<postorder.length;i++){
            map.put(postorder[i],i);
        }
        return build(0, preorder.length-1, 0,postorder.length-1,preorder,postorder);
    }
    public static TreeNode build(int presatrt, int preend, int posstart, int posend,
                                 int[] preorder, int[] postorder) {
        if(posstart>posend||presatrt>preend){
            return null;
        } else if (presatrt==preend) {
            return new TreeNode(preorder[presatrt]);
        }
        TreeNode root = new TreeNode(postorder[posend]);
        int index = map.get(preorder[presatrt+1]);
        int leftsize = index-posstart;
        int newlpreend = presatrt+leftsize+1;
        int newrprestart =newlpreend+1;
        root.left = build(presatrt+1,newlpreend,posstart,index,preorder,postorder);
        root.right = build(newrprestart,preend,index+1,posend-1,preorder,postorder);
        return root;
    }
}
