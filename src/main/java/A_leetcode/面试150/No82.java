package A_leetcode.面试150;

public class No82 {



    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }
    public  static ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return head;
        }
        //准备一个指针，指向头，这样头节点就不用单独讨论了
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode cur = result;

        //准备两个指针，一个指向当前节点，一个指向当前节点之后的节点

        ListNode cur1 = head;
        ListNode next1 = head.next;

        while (next1!=null){
           if (cur1.val==next1.val){
               //如果相等就调用函数，返回的是直到cur1不等于next1，
              cur.next = process(cur1,next1);
              //如果返回的是空，就说明链表结束了，直接return
              if (cur.next==null){
                  return result.next;
              }else {
                  //不是空，此时next
                  cur1=cur.next;
                  next1 = cur1.next;
              }
           }else {
               //不相等的话，很容易，直接都后移一位
               cur=cur.next;
               cur1=cur1.next;
               next1= next1.next;
           }
        }
        return result.next;
    }

    public static ListNode process(ListNode cur1,ListNode next1){
        //next1一直往后移动，直到找到和cur1不相等的那个
        while (next1!=null&&cur1.val==next1.val){
            next1=next1.next;
        }
        //cur1指向next1
        cur1 = next1;
        //如果是空，直接返回，说明到头了，如果不是，next1往后移动，继续比较，直到找到为空，或者next1不等于cur1
        if (next1!=null){
            next1 = next1.next;
            if (cur1==next1){
               return process(cur1,next1);
            }
        }
        return cur1;
    }

    public static void main(String[] args) {
        // 创建节点
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        // 连接节点
        node1.next = node2;
        deleteDuplicates(node1);

    }
}
