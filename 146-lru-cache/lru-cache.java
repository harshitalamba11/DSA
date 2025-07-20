class Node{
    int key,value;
    Node prev;
    Node next;
    Node(int key,int value){
        this.key=key;this.value=value;
    }
}

class LRUCache {
    int capacity=0;
    Node old=new Node(-1,-1);
    Node latest=new Node(-1,-1);
    Map<Integer,Node> map=new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity=capacity;
        old=new Node(0,0);latest=new Node(0,0);
        old.next=latest;
        latest.prev=old;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node del=map.get(key);
        remove(del);
        insert(del);
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node exist=map.get(key);
            exist.value=value;
            remove(exist);
            insert(exist);
        }
        else{
            if(map.size()>=capacity){
                map.remove(old.next.key);
                remove(old.next);
            }
            // map.remove(old.next);
        
        
            Node newnode=new Node(key,value);
            insert(newnode);
            map.put(key,newnode);
        }
    }
    public void remove(Node node){
        Node left=node.prev;
        left.next=node.next;
        node.next.prev=left;
    }
    public void insert(Node node){
        Node left=latest.prev;
        left.next=node;
        node.prev=left;
        node.next=latest;
        latest.prev=node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */