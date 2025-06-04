/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode,Boolean> m = new HashMap<>();

        while(head!=null){
            if(m.containsKey(head)){
                return true;
            }
            else{
                m.put(head,true);
            }
            head=head.next;
        }
        return false;
    }
}