package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.List;

public class No99 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.left = left;
        root.right  = new TreeNode(1);
        recoverTree(root);
    }


    static TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    static TreeNode first;
    static TreeNode second;
    public static void recoverTree(TreeNode root) {
        process(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }



    public static void process(TreeNode node){
        if (node==null){
            return;
        }else {
            process(node.left);
            if (node.val< pre.val){
                first = pre;
                second = node;
            }
            pre = node;
            process(node.right);
        }
    }
}
