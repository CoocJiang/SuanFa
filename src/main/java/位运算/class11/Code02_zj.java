package 位运算.class11;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Code02_zj {

    //中序遍历
    public static void zx(TreeNode node) {
        TreeNode cur = node;
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> listans = new LinkedList<>();
        while (stack.isEmpty() || cur != null) {
            if (cur != null) {
                cur = cur.left;
                stack.add(cur);
            } else {
                cur = stack.pop();
                listans.add(cur.val);
                cur = cur.right;
            }
        }
    }

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {

      }
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    //先序遍历，使用栈实现
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> listans = new LinkedList<>();
        if (root==null){
            return listans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode cur ;
        while (!stack.isEmpty()){
            cur = stack.pop();
            listans.add(cur.val);
            if (cur.right!=null){
                stack.push(cur.right);
            }
            if (cur.left!=null){
                stack.push(cur.left);
            }
        }
        return listans;
    }


    //中序遍历 使用递归实现
    public  List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> listans = new LinkedList<>();
        if (root==null){
            return listans;
        }
        process(root,listans);
        return listans;
    }
    public static void process(TreeNode root,LinkedList<Integer> listans){
        if (root.left!=null){
            process(root.left,listans);
        }
        listans.add(root.val);
        if (root.right!=null){
            process(root.right,listans);
        }
    }

    //使用栈实现中序遍历


    //后续遍历 使用递归实现
    public  List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> listans = new LinkedList<>();
        if (root==null){
            return listans;
        }
        process1(root,listans);
        return listans;
    }
    public static void process1(TreeNode root,LinkedList<Integer> listans){
        if (root.left!=null){
            process1(root.left,listans);
        }
        if (root.right!=null){
            process1(root.right,listans);
        }
        listans.add(root.val);
    }
}
