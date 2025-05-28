/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        LinkedHashSet<Integer> hs = new LinkedHashSet<>();

        if(head==null) {
            return null;
        }
        ListNode headOrigin = head;
        while(head.next!=null){
            // System.out.println(head.val);
            hs.add(head.val);
            head=head.next; 
        }
        hs.add(head.val);

        if(hs.size()==0) return new ListNode();

        ListNode retHead = new ListNode(headOrigin.val);

        
        ListNode ptr = retHead;
        boolean first=true;
        for(int i : hs){
            if(first){
                first=false;
                continue;
            }
            ListNode nxt = new ListNode();
            nxt.val=i;
            ptr.next=nxt;
            ptr=ptr.next;
        }

        System.out.println(hs);

        return retHead;
    }
}