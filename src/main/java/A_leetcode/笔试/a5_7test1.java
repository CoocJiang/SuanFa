package A_leetcode.笔试;

import java.util.HashMap;

public class a5_7test1 {

     public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
      this.val = val;
    }
  }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left  = new TreeNode(2);
        TreeNode node3 = root.right = new TreeNode(3);
        node3.left = new TreeNode(4);
        node3.right = new TreeNode(5);

        int [] iorder = {2,1,4,3,5};
        int [] po = {2,4,5,3,1};
        System.out.println(buildTree(iorder,po));
    }

    public static TreeNode buildTree (int[] inorder, int[] postorder) {
        // write code here
        int [] inmap = new int[1000*1000*1000];
        for(int i = 0;i<inorder.length;i++){
            inmap[inorder[i]] = i;
        }
           return process(postorder,0,postorder.length-1,inmap);

    }

    public static TreeNode process(int[] postorder,int left,int right,int [] inmap ){
         //basecase
        if (left==right){
            return new TreeNode(postorder[left]);
        }
        //是一个数组的话
        //先返回头节点
        TreeNode root = new TreeNode(postorder[right]);
        root.left = process(postorder,left,inmap[postorder[right]]-1,inmap);
        root.right = process(postorder,inmap[postorder[right]],right-1,inmap);
        return root;
    }
}
