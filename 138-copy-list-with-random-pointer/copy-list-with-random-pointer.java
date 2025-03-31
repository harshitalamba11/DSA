/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        // step 1 where we are inserting copy duplicate in next to real one node
        Node temp=head;
        while(temp!=null){
            Node nextnode=temp.next;
            Node newnode=new Node(temp.val);
            temp.next=newnode;
            newnode.next=nextnode;
            temp=nextnode;
        }
        temp=head;

        // step 2 we make connections
        while(temp!=null){
            if(temp.random!=null)
            temp.next.random=temp.random.next;
            else
            temp.next.random=null;
            temp=temp.next.next;
        }

        // step 3 after making the connections now we will separate the original and dummy
        Node original=head;
        Node copy=head.next;
        Node finalcopy=copy;
        while(original!=null){
            original.next=original.next.next;
            if(copy.next!=null) copy.next=copy.next.next;
            copy=copy.next;
            original=original.next;
        }
        return finalcopy;
        





        
        // if(head==null){
        //     return null;
        // }
        // Node temp=head;
        // while(temp!=null){
        //     Node nextnode=temp.next;
        //     Node newnode=new Node(temp.val);
        //     temp.next=newnode;
        //     newnode.next=nextnode;
        //     temp=nextnode;
        // }
        // temp=head;
        // while(temp!=null){
        //     if(temp.random!=null)
        //         temp.next.random=temp.random.next;
        //     else
        //         temp.next.random=null;
            
        //     temp=temp.next.next;
        // }
        // Node original=head;
        // Node copy=head.next;
        // Node tem=copy;
        // while(original!=null){
        //     original.next=original.next.next;
        //     if (copy.next != null) {
        //         copy.next = copy.next.next;
        //     }
        //     copy=copy.next;
        //     original=original.next;
        // }
        // return tem;
        



    }
}