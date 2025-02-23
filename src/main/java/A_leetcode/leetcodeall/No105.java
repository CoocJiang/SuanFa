package A_leetcode.leetcodeall;

import java.util.HashMap;

public class No105 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(0,preorder.length-1,0,preorder.length-1,preorder,inorder,map);
    }


    public static TreeNode build(int prestart,int preend,int insatrt,int inend,int[] preorder, int[] inorder,HashMap<Integer,Integer>  map) {
        if (prestart > preend) {
            return null;
        }
        TreeNode root  = new TreeNode(preorder[prestart]);
        int index = map.get(preorder[prestart]);
        root.left = build(prestart+1,index-insatrt+prestart,insatrt,index-1,preorder,inorder,map);
        root.right = build(index-insatrt+prestart+1,preend,index+1,inend,preorder,inorder,map);
        return root;
    }


    public static void main(String[] args) {
        buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }
}
