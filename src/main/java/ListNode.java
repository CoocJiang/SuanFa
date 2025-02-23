import java.util.concurrent.ConcurrentHashMap;

public class ListNode {

      int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();
        map.put("key",1);
        map.compute("key",(key,old) -> old+1);
        System.out.println(map.get("key"));
    }
}
