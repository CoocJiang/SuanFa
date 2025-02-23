package A_leetcode.面试150;

import com.sun.org.apache.xml.internal.utils.PrefixResolver;

public class No129 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


    public static int sumNumbers(TreeNode root) {
        if (root.right==null&&root.left==null){
            return root.val;
        }
        return process(root.val,root.right)+process(root.val,root.left);
    }

    private static int process(int presum,TreeNode node) {
        if (node==null){
            return 0;
        }
        presum=presum*10+ node.val;
        if (node.right==null&&node.left==null){
            return presum;
        }else {
           return process(presum,node.left) + process(presum,node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode left1 = new TreeNode(5,null,null);
        TreeNode left2= new TreeNode(1,null, null);
        TreeNode left = new TreeNode(9,left1,left2);
        TreeNode ri = new TreeNode(0,null,null);
        TreeNode root = new TreeNode(4,left,ri);

        System.out.println(sumNumbers(root));
    }
}
