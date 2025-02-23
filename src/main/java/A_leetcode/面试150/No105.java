package A_leetcode.面试150;

import java.util.HashMap;

public class No105 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int [] p = {3,9,20,15,7};
        int [] o = {9,3,15,20,7};
        buildTree(p,o);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
       for (int i=0;i<inorder.length;i++){
         map.put(inorder[i],i);
       }
       return process(preorder,map,0,inorder.length-1,0,inorder.length-1);
    }


    public static TreeNode process(int[] preorder, HashMap<Integer,Integer> map , int preleft, int preright, int inleft, int inright){
        //如果没有子节点
        if(preleft == preright){
            return new TreeNode(preorder[preleft]);
        }
        else if(preleft > preright){
            return null;
        }

        //说明还有子节点

        //map.get(preorder[preleft]) 代表 PIdex
        int Pindex = map.get(preorder[preleft]);
        TreeNode root  = new TreeNode(preorder[preleft]);
        //递归构建左子树
        root.left = process(preorder,map, preleft +1, map.get(preorder[preleft])-inleft+ preleft, inleft, map.get(preorder[preleft])-1);

        //递归构建右子树

        //这里preleft就是X，因为preright - preleft = inright - Pindex
        // 所以 preleft = preright-inright+PIndex+1
        //替换之后就发现是错误的
         int preleft1 = preright-inright+ map.get(preorder[preleft])+1;
        root.right = process(preorder,map,preleft1,preright,map.get(preorder[preleft])+1,inright);
        return root;
    }
}
