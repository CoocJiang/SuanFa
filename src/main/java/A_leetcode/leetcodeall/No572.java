package A_leetcode.leetcodeall;

import java.util.ArrayDeque;
import java.util.Queue;

public class No572 {


      static public class TreeNode {
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
    static TreeNode [] queue = new TreeNode[2001];

    static TreeNode [] aq = new TreeNode[1001];
    static TreeNode [] bq = new TreeNode[1001];
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        int left = 0;
        int right = 0;
        queue[right++] = root;
        TreeNode cur;
        while (left!=right){
            cur = queue[left++];
            if (cur.val == subRoot.val){
                if (process(cur,subRoot)){
                    return true;
                }
            }
            if (cur.left!=null){
                queue[right++] = cur.left;
            }
            if (cur.right!=null){
                queue[right++] = cur.right;
            }
        }
        return false;
    }

    public static boolean process(TreeNode a,TreeNode b){
          int aleft = 0;
          int aright = 0;
          int bleft = 0;
          int bright = 0;
          aq[aright++] = a;
          bq[bright++] = b;
          TreeNode cura;
          TreeNode curb;
          while (aleft<aright&& bleft<bright){
              cura = aq[aleft++];
              curb = bq[bleft++];
              if (cura.val == curb.val){
                  if (curb.left!=null&&cura.left!=null){
                      bq[bright++] = curb.left;
                      aq[aright++] = cura.left;
                  }else if (curb.left==null&&cura.left==null){

                  }else {
                      return false;
                  }
                  if (curb.right!=null&&cura.right!=null){
                      bq[bright++] = curb.right;
                      aq[aright++] = cura.right;
                  } else if (curb.right==null&&cura.right==null){

                  }else {
                      return false;
                  }
              }else {
                  return false;
              }
          }
          return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subroot = new TreeNode(4);
        subroot.left = new TreeNode(1);
        subroot.right = new TreeNode(2);

        System.out.println(isSubtree(root, subroot));
    }
}
