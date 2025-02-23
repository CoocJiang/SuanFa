package A_leetcode.尊享100.BFS.链表;

public class No1474 {
      static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        // 创建链表的最后一个节点
        ListNode node13 = new ListNode(13);

        // 依次创建前面的节点，并将它们链接在一起
        ListNode node12 = new ListNode(12, node13);
        ListNode node11 = new ListNode(11, node12);
        ListNode node10 = new ListNode(10, node11);
        ListNode node9 = new ListNode(9, node10);
        ListNode node8 = new ListNode(8, node9);
        ListNode node7 = new ListNode(7, node8);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        // node1 现在是链表的头节点
        ListNode head = node1;
        deleteNodes(head,2,3);
    }
    public static ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode cur = head;
        boolean flag = true;
        int count = 1;
        while(cur!=null){
            if(flag){
                if(count<m){
                    cur = cur.next;
                    count++;
                }else{
                    flag = false;
                    count = 0;
                }
            }else{
                ListNode cur1 = cur;
                while(cur1!=null&&count<n){
                    cur1 = cur1.next;
                    count++;
                }
                if (cur1 != null) {
                    cur.next = cur1.next;
                }else {
                    cur.next=null;
                }
                count=0;
                flag = true;
            }
        }
        return head;
    }
}
