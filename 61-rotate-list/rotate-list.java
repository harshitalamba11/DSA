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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        ListNode temp=head;
        int len=1;
        while(temp.next!=null){
            len++;
            temp=temp.next;
        }
        
        k=k%len;
        if(k==0) return head;
        temp.next=head;
        int d=(len>k)?len-k:k-len;
        ListNode curr=head;
        while(d>1){
            curr=curr.next;
            d--;
        }
        ListNode newnode=curr.next;
        curr.next=null;
        return newnode;
    }
}
















/*
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;  // No rotation needed for empty list, single node, or no rotation requested
        }
        ListNode temp=head;
        int len=1;
        while(temp.next!=null){
            len++;
            temp=temp.next;
        }
        
        k=k%len;
        if(k==0){
            return head;
        }
        temp.next=head;
        ListNode curr=head;
        int a=k>len?k-len:len-k;
        while(a>1){
            curr=curr.next;
            a--;
        }

        ListNode nextnode=curr.next;
        curr.next=null;
        return nextnode;
    }
}
*/