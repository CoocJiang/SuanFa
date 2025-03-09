package A_leetcode.leetcodeall;

public class No160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode fst = headA;
        ListNode snd = headB;
        while(fst!=snd){
            if(fst == null){
                fst = headB;
            }else{
                fst = fst.next;
            }
            if(snd==null){
                snd = headA;
            }else{
                snd = snd.next;
            }
        }
        return fst;
    }
    
}
