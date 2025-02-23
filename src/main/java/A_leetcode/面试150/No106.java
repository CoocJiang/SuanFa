package A_leetcode.面试150;

import java.util.HashMap;

public class No106 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int [] in = {9,3,15,20,7};
        int [] po = {9,15,7,20,3};
        buildTree(in,po);
    }



    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        HashMap<Integer,Integer> map= new HashMap<>();
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }


        return build(0,inorder.length-1,0,inorder.length-1,map,inorder,postorder);
    }


    public static TreeNode build(int instart,int inend,int posstart,int posend,HashMap<Integer,Integer>map,int[] inorder, int[] postorder){
        if(instart<inend){
            return null;
        }

        TreeNode root = new TreeNode(postorder[posend]);
        int index = map.get(postorder[posend]);
        root.left = build(instart,index-1,posstart,posstart+index-1-instart,map,inorder,postorder);
        root.right = build(index+1,inend,posend+index-inend,posend-1,map,inorder,postorder);
        return root;
    }











//    public static TreeNode buildTree(int[] inorder,int[] postrder ) {
//        if(postrder.length==0){
//            return null;
//        }
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int i=0;i<inorder.length;i++){
//            map.put(inorder[i],i);
//        }
//        return process(postrder,map,0,inorder.length-1,0,inorder.length-1);
//    }
//
//
//    public static TreeNode process(int[] postorder, HashMap<Integer,Integer> map , int preleft, int preright, int inleft, int inright){
//        //如果没有子节点
//        if(preleft == preright){
//            return new TreeNode(postorder[preright]);
//        }
//        else if(preleft > preright){
//            return null;
//        }
//        int Pindex = map.get(postorder[preright]);
//        TreeNode root  = new TreeNode(postorder[preright]);
//
//        root.left = process(postorder,map, preleft, preright-inright+Pindex-1, inleft, Pindex-1);
//
//        root.right = process(postorder,map,preright-inright+Pindex,preright-1,Pindex+1,inright);
//        return root;
//    }
}
