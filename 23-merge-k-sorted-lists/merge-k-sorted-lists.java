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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root=new ListNode(0);
        ListNode head=root;
        PriorityQueue< ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }
        
        while(!pq.isEmpty()){
            ListNode temp=pq.peek();
            head.next=pq.poll();
            if(temp.next!=null){
                pq.add(temp.next);
            }
            head=head.next;

        }
        return root.next;
    }
}