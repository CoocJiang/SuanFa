package A_leetcode.面试150;

import java.util.Stack;

public class No114 {

    public class TreeNode {
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
    public void flatten(TreeNode root) {
        if (root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        process(root,stack);
    }
    public static void process(TreeNode root,Stack<TreeNode> stack){
        //先把当前节点的右节点压入栈,在压入左节点进入,然后弹出，然后把当前节点接入链表，在压入
        stack.push(root);
        TreeNode cur = null;
        TreeNode ahead = null;
        while (!stack.isEmpty()){
           cur=stack.pop();
           if (ahead!=null){
               ahead.right=cur;
               ahead.left=null;
           }
           if (cur.right!=null){
               stack.push(cur.right);
           }
           if (cur.left!=null){
               stack.push(cur.left);
           }
           ahead=cur;
       }
    }
    //更优秀的解法
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        TreeNode ahead = null;
        TreeNode bhead = null;
        while (cur.left!=null||cur.right!=null){
            if (cur.left==null){
                cur=cur.right;
                continue;
            }
            //先将右边存储起来
            ahead = cur.right;
            //当前节点的右边等于左边
            cur.right = cur.left;
            //左边设置为null
            cur.left = null;
            //下一个节点为当前节点的左节点
            cur = cur.right;

            bhead = cur;
            while (bhead.right!=null){
                bhead = bhead.right;
            }
            bhead.right = ahead;
        }
    }
}
