package A_leetcode.leetcodeall;

public class No662 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }

     static class Node{
        int id;
        TreeNode treeNode;

        public Node(int id,TreeNode node){
            this.id = id;
            this.treeNode = node;
        }
    }

    static  Node [] nods = new Node[6001];
    public static int widthOfBinaryTree(TreeNode root) {
        int l = 0;
        int r = 0;
        if (root==null){
            return 1;
        }
        nods[r++] = new Node(1,root);
        int size = 0;
        int max = 0;
        while (l<r){
            int begin = 0,end = 0;
            size = r-l;
            int ans = size;
            for (int i = 0; i < size; i++) {
                Node cur = nods[l++];
                TreeNode curNode = cur.treeNode;
                int curId = cur.id;
                // 记录当前行第一个和最后一个节点的编号
                if (i == 0) {
                    begin = curId;
                }
                if (i == size - 1) {
                    end = curId;
                }
                // 左右子节点入队，同时记录对应节点的编号
                if (curNode.left != null) {
                    nods[r++] = new Node( curId * 2,curNode.left);
                }
                if (curNode.right != null) {
                    nods[r++] = new Node( curId * 2+1,curNode.right);
                }
            }
            // 用当前行的宽度更新最大宽度
            max = Math.max(max, end - begin + 1);
        }
        return max;
    }
}
