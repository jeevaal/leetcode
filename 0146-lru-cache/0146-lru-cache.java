class Node
{
    Node prev;
    int key;
    int value;
    Node next;
    
    Node(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    
    HashMap<Integer, Node> hm = new HashMap<>();
    int capacity = 0;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(hm.containsKey(key))
        {
            Node node = hm.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key))
        {
            Node node = hm.get(key);
            remove(node);
        }
        if(hm.size() == capacity)
            remove(tail.prev);
        insert(new Node(key, value));
    }
    
    public void insert(Node newNode)
    {
        hm.put(newNode.key, newNode);
        newNode.next = head.next;
        newNode.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
    }
    
    public void remove(Node node)
    {
        hm.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */