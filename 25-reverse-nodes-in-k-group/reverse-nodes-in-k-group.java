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
    public ListNode getkthNode(ListNode temp,int k){
        k=k-1;
        while(k>0 && temp!=null){
            k--;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode reverse(ListNode temp){
        if(temp==null || temp.next==null){
            return temp;
        }
        ListNode newnode=reverse(temp.next);
        temp.next.next=temp;
        temp.next=null;
        return newnode;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode kthNode=getkthNode(temp,k);
            if(kthNode==null){
                if(prev!=null){
                    prev.next=temp;
                    return head;
                }
            }
            ListNode newNode=kthNode.next;
            kthNode.next=null;
            ListNode reverseHead=reverse(temp);
            if(head==temp){
                head=kthNode;
            }
            else{
                prev.next=kthNode;
            }
            prev=temp;
            temp=newNode;
        }
        return head;
    }
}












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
 /*
class Solution {
    public ListNode getkthNode(ListNode temp,int k){
        k=k-1;                                              
        while(k>0 && temp!=null){
            k--;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode kthNode=getkthNode(temp,k);
            if(kthNode==null){
                if(prev!=null){
                    prev.next=temp;
                    // break;
                    return head;
                }
            }
            ListNode nextNode=kthNode.next;
            kthNode.next=null;
            ListNode reversedHead=reverse(temp);
            if(head==temp){
                head=kthNode;
            }
            else{
                prev.next=kthNode;
            }
            prev=temp;
            temp=nextNode;
        }
        return head;
    }
    public ListNode reverse(ListNode head){
        // ListNode temp=head;
        if(head==null || head.next==null){
            return head;
        }
        ListNode reversedList = reverse(head.next);
        head.next.next = head;
    
    // Set the current node's next to null, as it will be the new tail of the reversed list
    head.next = null;
    
    return reversedList;
    }
}
*/